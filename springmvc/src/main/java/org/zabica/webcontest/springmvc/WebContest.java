package org.zabica.webcontest.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class WebContest {

	@RequestMapping("webcontest")
    public Object webcontest() {
		
		ModelAndView mav = new ModelAndView("index");
    	return mav;
    }
}
