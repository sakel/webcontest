package org.zabica.webcontest.springmvc;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.zabica.webcontest.common.user.User;
import org.zabica.webcontest.common.venue.Conference;
import org.zabica.webcontest.springmvc.beans.ConferenceRequest;
import org.zabica.webcontest.springmvc.beans.DBBean;
import org.zabica.webcontest.springmvc.beans.UserLogin;
import org.zabica.webcontest.springmvc.beans.UserRegistration;
import org.zabica.webcontest.springmvc.beans.UserSession;
import org.zabica.webcontest.springmvc.helpers.ErrorHelper;

@Controller
@RequestMapping("/webcontest")
@SessionAttributes(types={ UserSession.class })
public class WebContest {

	private static final Logger LOG = LoggerFactory.getLogger(WebContest.class);
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserSession userSession;
	
	@Autowired
	private ConversionService conversionService;
	
	@Autowired
	private DBBean db;
	
	@ModelAttribute("userLogin")
	public UserLogin userLogin() {
		UserLogin ul = new UserLogin();
		return ul;
	}
	
	@ModelAttribute("registration")
	public UserRegistration registration() {
		UserRegistration ur = new UserRegistration();
		return ur;
	}
	
	@ModelAttribute("conference")
	public Conference conference() {
		Conference conf = new Conference();
		return conf;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Object webcontest(@RequestParam(required = false) String name,
			HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) {

		if(this.userSession.isLoggedIn()) {
			
			return new RedirectView("/webcontest/conferences", true);
		}
		
		ModelAndView mav = new ModelAndView("index");
		if (name != null) {
			User user = new User();
			user.setFirstName(name);
			mav.addObject("user", user);
		}
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public Object login() {
		if(this.userSession.isLoggedIn()) {
			return new RedirectView("/webcontest/conferences", true);
		}
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(@ModelAttribute @Validated UserLogin userLogin, BindingResult result) {
		System.out.println("Checking if logged in");
		
		if(this.userSession.isLoggedIn()) {
			return new RedirectView("/webcontest/conferences", true);
		}
		System.out.println("Pass: " + userLogin.getPassword());
		
		User user = this.db.getUser(userLogin.getEmail());
		if(user == null) {
			LOG.info("User "+ userLogin.getEmail() +" doesn't exist");
			result.addError(new FieldError("userLogin", "email", this.messageSource.getMessage("password.wrong", new Object[] {}, Locale.getDefault())));
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("errors", ErrorHelper.getErrorMap(result));
			return mav;
		}
		
		System.out.println("Recieved: " + userLogin.getEmail());
		System.out.println("Pass = " + user.toString());
		
		this.userSession.setLoggedIn(true);
		this.userSession.setUser(user);
		return new RedirectView("/webcontest/conferences", true);
	}

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	@ResponseBody
	public Object logout() {
		this.userSession.setLoggedIn(false);
		this.userSession.setUser(null);
		return new RedirectView("/webcontest/login", true);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@ResponseBody
	public Object register() {
		
		if(this.userSession.isLoggedIn()) {
			return new RedirectView("/webcontest/conferences", true);
		}
		
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Object register(@ModelAttribute @Validated UserRegistration registration, BindingResult result) {
		ModelAndView mav = new ModelAndView("register");
		if(result.hasErrors()) {
			mav.addObject("errors", ErrorHelper.getErrorMap(result));
			Map<String, String> errs = ErrorHelper.getErrorMap(result);
			for(String err : errs.keySet()) {
				System.out.println("ERR: " + err + " :: " + errs.get(err));
			}
			return mav;
		}

		User user = new User();
		user.setFirstName(registration.getName());
		user.setLastName(registration.getSurname());
		user.setEmail(registration.getEmail());
		user.setPassword(registration.getPassword());
		
		if(!this.db.addUser(user)) {
			System.out.println("BLAH");
			FieldError fe = new FieldError("registration", "email", this.messageSource.getMessage("email.taken", new Object[] {}, Locale.getDefault()));
			result.addError(fe);
			mav.addObject("errors", ErrorHelper.getErrorMap(result));
			return mav;
		}
		
		return new RedirectView("/webcontest/login", true);
	}

	@RequestMapping(value="/users", method=RequestMethod.GET)
	public Object listObjects() {
		ModelAndView mav = new ModelAndView("users");
		mav.addObject("users", this.db.getAllUsers());
		return mav;
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public Object remove(@RequestParam String user) {
		if(!this.db.removeUser(user)) {
			return "ERROR";
		}
		
		return new RedirectView("/webcontest/users", true);
	}
	
	@RequestMapping(value="/conferences", method=RequestMethod.GET)
	@ResponseBody
	public Object conferences() {
		List<Conference> confs = this.db.getConferences(new Date(), null);
		
		ModelAndView mav = new ModelAndView("conferences");
		mav.addObject("conferences", confs);
		return mav;
	}
	
	@RequestMapping(value="/conferences", method=RequestMethod.POST)
	@ResponseBody
	public Object conferences(@RequestParam(required=false) List<String> tags, @RequestParam(required=false) String date) {	
		Date newDate = new Date();
		try {
			newDate = this.conversionService.convert(date, Date.class);
		} catch (Exception e) {
			LOG.info("Could not convert to date object");
		}
		List<Conference> confs = this.db.getConferences(newDate, tags);
		
		ModelAndView mav = new ModelAndView("conferences");
		mav.addObject("conferences", confs);
		return mav;
	}
	
	@RequestMapping(value="/conference", method=RequestMethod.GET)
	@ResponseBody
	public Object conferenceById(@RequestParam(required=false) String confid) {
		if(confid == null || confid.isEmpty()) {
			List<Conference> confs = this.db.getConferences(new Date(), null);
			ModelAndView mav = new ModelAndView("conferences");
			mav.addObject("conferences", confs);
			return mav;
		}
		
		Conference conf = this.db.getConference(confid);
		if(conf == null) {
			List<Conference> confs = this.db.getConferences(new Date(), null);
			ModelAndView mav = new ModelAndView("conferences");
			mav.addObject("conferences", confs);
			return mav;
		}
				
		ModelAndView mav = new ModelAndView("conference");
		mav.addObject("conference", conf);
		return mav;
	}
	
	@RequestMapping(value="/addconference", method=RequestMethod.GET)
	@ResponseBody
	public Object addconference() {
		ModelAndView mav = new ModelAndView("addconference");
		return mav;
	}
	
	@RequestMapping(value="/addconference", method=RequestMethod.POST)
	@ResponseBody
	public Object addconference(@ModelAttribute @Validated ConferenceRequest conference, BindingResult result) {
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView("addconference");
			mav.addObject("errors", ErrorHelper.getErrorMap(result));
			return mav;
		}
		
		if(!this.db.addConference(conference.toConference())) {
			LOG.warn("Conference not added");
			System.out.println("Conference not added");
		}
		
		System.out.println("Conference added");
		return new RedirectView("/webcontest/conferences", true);
	}
	
	@RequestMapping(value="/setlanguage", method=RequestMethod.GET)
	@ResponseBody
	public Object setlanguage(@RequestParam String locale, @RequestParam String source) {
		String[] locarr = locale.split("[_]");
		Locale loc = new Locale(locarr[0], locarr[1]);
		
		this.userSession.getUser().setLocale(loc);
		this.db.updateUser(this.userSession.getUser());
		
		return new RedirectView(source, true);
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public UserSession getUserSession() {
		return userSession;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}

	public DBBean getDb() {
		return db;
	}

	public void setDb(DBBean db) {
		this.db = db;
	}

	public ConversionService getConversionService() {
		return conversionService;
	}

	public void setConversionService(ConversionService conversionService) {
		this.conversionService = conversionService;
	}
}
