package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LibraryControllerBean implements LibraryController {

    @NonNull
    @Override
    @GetMapping("/ui/libraries")
    public ModelAndView libraries() {
        @NonNull final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("libraries");
        return modelAndView;
    }

}
