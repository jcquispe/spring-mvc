package com.juanky;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello(ModelMap model) {
        model.addAttribute("message", "Hello World from Spring MVC");
        return "hello";
    }
}
