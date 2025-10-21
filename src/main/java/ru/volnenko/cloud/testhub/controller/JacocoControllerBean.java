package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public final class JacocoControllerBean implements JacocoController {

    @NonNull
    @Override
    public ModelAndView results(@PathVariable("artifactId") @NonNull final String artifactId) {
        @NonNull final ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

}
