package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.volnenko.cloud.testhub.service.ArtifactService;

@Controller
public final class ApplicationControllerBean implements ApplicationController {

    @Autowired
    private ArtifactService artifactService;

    @NonNull
    @Override
    public ModelAndView applications() {
        @NonNull final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("applications");
        modelAndView.addObject("artifacts", artifactService.findAllApplication());
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
