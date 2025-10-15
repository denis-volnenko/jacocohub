package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.volnenko.cloud.testhub.service.ArtifactService;
import ru.volnenko.cloud.testhub.service.JacocoService;

@Controller
public class ArtifactControllerBean implements ArtifactController {

    @Autowired
    private ArtifactService artifactService;

    @Autowired
    private JacocoService jacocoService;

    @NonNull
    @Override
    @GetMapping("/ui/artifacts")
    public ModelAndView artifacts() {
        @NonNull final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("artifacts");
        modelAndView.addObject("artifacts", artifactService.findAll());
        return modelAndView;
    }

    @NonNull
    @Override
    public ModelAndView artifact(@PathVariable("artifactId") @NonNull final String artifactId) {
        @NonNull final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("artifact");
        modelAndView.addObject("artifact", artifactService.findById(artifactId).orElse(null));
        modelAndView.addObject("results",  jacocoService.findAllByArtifactId(artifactId));
        return modelAndView;
    }

}
