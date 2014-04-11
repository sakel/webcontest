package org.zabica.webcontest.stripes.actions;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.ScopedLocalizableError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationError;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zabica.webcontest.common.user.User;
import org.zabica.webcontest.common.venue.Conference;
import org.zabica.webcontest.stripes.beans.DBBean;
import org.zabica.webcontest.stripes.beans.SessionActionBeanContext;
import org.zabica.webcontest.stripes.beans.UserRegistration;
import org.zabica.webcontest.stripes.converter.LocaleConverter;
import org.zabica.webcontest.stripes.converter.TagConverter;

@UrlBinding("/webcontest/{$event}")
public class WebContestActionBean implements ActionBean, ValidationErrorHandler {

	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final Logger LOG = LoggerFactory.getLogger(WebContestActionBean.class);
	
	@SpringBean
	private DBBean dbbean;
	
	private SessionActionBeanContext context;
	
	@Validate(required = true, mask = EMAIL_PATTERN, on = { "doLogin" })
	private String email;
	@Validate(required = true, on = { "doLogin" })
	private String password;
	
	@ValidateNestedProperties({
		@Validate(field="name", required=true, on = { "doRegister" }),
		@Validate(field="surname", required=true, on = { "doRegister" }),
		@Validate(field="email", required=true, mask=EMAIL_PATTERN, on = { "doRegister" }),
		@Validate(field="password", required=true, minlength=6, on = { "doRegister" }),
		@Validate(field="repeatPassword", required=true, minlength=6, on = { "doRegister" })
	})
	private UserRegistration register;
	
	@Validate(converter=LocaleConverter.class, on = { "setlanguage" } )
	private Locale locale;
	@Validate(on = { "setlanguage" } )
	private String source;
	
	@ValidateNestedProperties({
		@Validate(field="title", required=true, on = { "doAddConf" } ),
		@Validate(field="description", required=true, on = { "doAddConf" } ),
		@Validate(field="start", required=true, mask="\\d{2}/\\d{2}/\\d{4}", on = { "doAddConf" } ),
		@Validate(field="duration", required=true, on = { "doAddConf" } ),
		@Validate(field="registrationDeadline", required=true, mask="\\d{2}/\\d{2}/\\d{4}", on = { "doAddConf" } ),
		@Validate(field="maxAttendees", required=true, on = { "doAddConf" } ),
		@Validate(field="fee", required=true, on = { "doAddConf" } ),
		@Validate(field="location", required=true, on = { "doAddConf" } ),
		@Validate(field="tags", required=true, converter=TagConverter.class, on = { "doAddConf" } ),
	})
	private Conference conference;
	
	@Validate(on = { "conferences" })
	private Date date;
	@Validate(converter=TagConverter.class, on = { "conferences" })
	private List<String> tags;
	
	private String confid;
	
	private List<Conference> conferences;
	
	private Date now = new Date();
	private boolean alreadyExists;
	private List<User> users;
	
	@Override
	public void setContext(ActionBeanContext context) {
		this.context = (SessionActionBeanContext) context;
	}

	@Override
	public ActionBeanContext getContext() {
		return this.context;
	}

	@DefaultHandler
	public Resolution index() {
		String evt = "login";
		if(this.context.getUser() != null) {
			evt = "conferences";
		}
		RedirectResolution rr = new RedirectResolution(WebContestActionBean.class, evt);
		LOG.debug("PATH: " + rr.getPath());
		return rr;
	}

	@HandlesEvent("login")
	public Resolution login() {
		return new ForwardResolution("/views/login.jsp");
	}
	
	@HandlesEvent("doLogin")
	public Resolution doLogin() {
		LOG.debug("User successfully logged in");
		return new RedirectResolution(WebContestActionBean.class, "conferences");
	}
	
	@HandlesEvent("register")
	public Resolution register() {
		return new ForwardResolution("/views/register.jsp");
	}
	
	@HandlesEvent("doRegister")
	public Resolution doRegister() {
		LOG.debug("Registering user: " + this.register.getEmail());
		if(!this.dbbean.addUser(this.register)) {
			LOG.error("Could not persist user: " + this.register.getEmail());
			setAlreadyExists(true);
			return new ForwardResolution("/views/register.jsp");
		}
		
		return new RedirectResolution(WebContestActionBean.class);
	}
	
	@HandlesEvent("users")
	public Resolution users() {
		this.users = this.dbbean.getAllUsers();
		LOG.debug("Number of users: " + this.users.size());
		
		return new ForwardResolution("/views/users.jsp");
	}
	
	@HandlesEvent("conferences")
	public Resolution conferences() {
		Date newDate = new Date();
		if(this.date != null) {
			newDate = this.date;
		}
		this.conferences = this.dbbean.getConferences(newDate, this.tags);
		return new ForwardResolution("/views/conferences.jsp");
	}
	
	@HandlesEvent("conference")
	public Resolution conference() {
		
		LOG.debug("UUID = " + this.confid + " --- " + getContext().getRequest().getParameter("confid"));
		
		this.conference = this.dbbean.getConference(confid);
		if(this.conference == null) {
			return new RedirectResolution(WebContestActionBean.class, "conferences");
		}
		LOG.debug(this.conference.getDescription());
		return new ForwardResolution("/views/conference.jsp");
	}
	
	
	@HandlesEvent("addconference")
	public Resolution addconference() {
		return new ForwardResolution("/views/addconference.jsp");
	}
	
	
	@HandlesEvent("doAddConf")
	public Resolution doAddConf() {
		if(!this.dbbean.addConference(conference)) {
			LOG.error("Could not add ");
			LOG.debug("Could not add conference");
		} else {
			LOG.debug("ADDEDDDDDD");
		}
		
		return new RedirectResolution(WebContestActionBean.class, "conferences");
	}
	
	@HandlesEvent("logout")
	public Resolution logout() {
		context.setUser(null);
		return new RedirectResolution(WebContestActionBean.class);
	}
	
	@HandlesEvent("remconf")
	public Resolution remconf() {
		this.dbbean.remConference(this.confid);
		return new RedirectResolution(WebContestActionBean.class);
	}
	
	@HandlesEvent("setlanguage")
	public Resolution setlanguage() {
		LOG.debug("Setting locale: " + this.locale);
		this.context.getUser().setLocale(this.locale);
		this.dbbean.updateUser(this.context.getUser());
		return new RedirectResolution(this.source, true);
	}
	
	@Override
	public Resolution handleValidationErrors(ValidationErrors errors)
			throws Exception {
		for(List<ValidationError> errs : errors.values()) {
			for(ValidationError err : errs) {
				LOG.debug(err.getFieldName() + " " + err.getMessage(Locale.getDefault()));
			}
		}
		
		return null;
	}
	
	@ValidationMethod(on = { "doLogin" })
	public void validateLogin(ValidationErrors errors) {
		User u = this.dbbean.getUser(this.email);
		if(u == null || !u.isPasswordValid(this.password)) {
			errors.add("email", new ScopedLocalizableError("", "userPassInvalid"));
		} else {
			this.context.setUser(u);
		}
	}
	
	@ValidationMethod(on = { "doRegister" })
	public void validateRegister(ValidationErrors errors) {
		LOG.debug("PASS: " + this.register.getRepeatPassword() + " :: " + this.register.getPassword());
		if(!this.register.getRepeatPassword().equals(this.register.getPassword())) {
			errors.add("register.repeatPassword", new ScopedLocalizableError("", "notEqual"));
		}
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRegistration getRegister() {
		return register;
	}

	public void setRegister(UserRegistration register) {
		this.register = register;
	}

	public DBBean getDbbean() {
		return dbbean;
	}

	public void setDbbean(DBBean dbbean) {
		this.dbbean = dbbean;
	}

	public boolean isAlreadyExists() {
		return alreadyExists;
	}

	public void setAlreadyExists(boolean alreadyExists) {
		this.alreadyExists = alreadyExists;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

	public List<Conference> getConferences() {
		return conferences;
	}

	public void setConferences(List<Conference> conferences) {
		this.conferences = conferences;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getConfid() {
		return confid;
	}

	public void setConfid(String confid) {
		this.confid = confid;
	}

	public Date getNow() {
		return now;
	}

	public void setNow(Date now) {
		this.now = now;
	}
	
}
