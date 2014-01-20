package org.zabica.webcontest.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zabica.webcontest.common.store.PersistentStore;
import org.zabica.webcontest.common.user.User;
import org.zabica.webcontest.springmvc.beans.UserRegistration;
import org.zabica.webcontest.springmvc.beans.UserSession;

@Controller
@RequestMapping("/webcontest")
public class WebContest {

	private static final Logger LOG = LoggerFactory.getLogger(WebContest.class);
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserSession userSession;
	
	@Autowired
	private PersistentStore persistentStore;
	
	@RequestMapping(method = RequestMethod.GET)
	public Object webcontest(@RequestParam(required = false) String name,
			HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) {

		if(this.userSession.isLoggedIn()) {
			return new ModelAndView("conferences");
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
			return new ModelAndView("conferences");
		}
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(@RequestParam(required=true) String email, @RequestParam(required=true) String password) {
		if(this.userSession.isLoggedIn()) {
			return new ModelAndView("conferences");
		}
		
		User user = this.persistentStore.getUser(email);
		if(user == null) {
			LOG.info("User doesn't exist");
			
			return null;
		}
		
		
		
		return null;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@ResponseBody
	public Object register() {
		
		if(this.userSession.isLoggedIn()) {
			return new ModelAndView("conferences");
		}
		
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Object register(@Validated UserRegistration registration, BindingResult result) {
		String out = "YAAAY";
		if(result.hasErrors()) {
			for(ObjectError err : result.getAllErrors()) {
				if(err instanceof FieldError) {
					out += err.getClass().getSimpleName() + ((FieldError) err).getField() + " - " +  err.getCode() + "::" + err.getDefaultMessage() + "ddd\n";
					System.out.println(out);
				} else {
					out += err.getClass().getSimpleName() + err.getObjectName() + " - " +  err.getCode() + "::" + err.getDefaultMessage() + "ddd\n";
					System.out.println(out);
				}
			}
		}

		return out;
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

	public PersistentStore getPersistentStore() {
		return persistentStore;
	}

	public void setPersistentStore(PersistentStore persistentStore) {
		this.persistentStore = persistentStore;
	}
}
