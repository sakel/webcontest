package org.zabica.webcontest.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@Controller
public class HelloWorldController {

    @RequestMapping("/webcontest")
    @ResponseBody
    public String webcontest(Model model) {
        model.addAttribute("message", "webcontest");
        return "helloWorld";
    }
}
