package org.zabica.webcontest.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zabica.webcontest.common.user.User;

@Controller
@RequestMapping("/")
public class WebContest {

	@RequestMapping("webcontest")
	public Object webcontest(@RequestParam(required = false) String name,
			HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) {

		ModelAndView mav = new ModelAndView("index");
		if (name != null) {
			User user = new User();
			user.setFirstName(name);
			mav.addObject("user", user);
		}
		return mav;
	}
}
