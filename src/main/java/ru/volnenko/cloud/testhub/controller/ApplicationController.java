package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public interface ApplicationController {

    @NonNull
    @GetMapping("/ui/applications")
    ModelAndView applications();

    @NonNull
    @GetMapping("/ui/application/{applicationId}")
    ModelAndView application(@PathVariable("applicationId") @NonNull String applicationId);

}
