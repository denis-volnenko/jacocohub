package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.volnenko.cloud.testhub.service.ArtifactService;

@Controller
public interface ArtifactController {

    @NonNull
    @GetMapping("/ui/artifacts")
    ModelAndView artifacts();

    @NonNull
    @GetMapping("/ui/artifact/{artifactId}")
    ModelAndView artifact(@PathVariable("artifactId") @NonNull String artifactId);

}
