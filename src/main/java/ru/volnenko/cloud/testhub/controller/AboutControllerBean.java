package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutControllerBean implements AboutController {

    @NonNull
    @Override
    @GetMapping("/ui/about")
    public ModelAndView about() {
        return new ModelAndView("about");
    }

}
