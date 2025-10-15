package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationControllerBean implements ApplicationController {

    @NonNull
    @Override
    public ModelAndView applications() {
        @NonNull final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("applications");
        return modelAndView;
    }

    @NonNull
    @Override
    public ModelAndView application(@PathVariable("applicationId") @NonNull final String applicationId) {
        @NonNull final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("application");
        return modelAndView;
    }

}
