package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public interface JacocoController {

    @NonNull
    @GetMapping("/ui/jacoco/results/{artifactId}")
    ModelAndView results(@PathVariable @NonNull String artifactId);

}
