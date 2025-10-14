package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/test")
    public ModelAndView get() {
        @NonNull final ModelAndView result = new ModelAndView();
        result.setViewName("index");
        return result;
    }

}
