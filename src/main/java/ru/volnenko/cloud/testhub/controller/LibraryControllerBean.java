package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.volnenko.cloud.testhub.service.ArtifactService;

@Controller
public final class LibraryControllerBean implements LibraryController {

    @Autowired
    private ArtifactService artifactService;

    @NonNull
    @Override
    @GetMapping("/ui/libraries")
    public ModelAndView libraries() {
        @NonNull final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("libraries");
        modelAndView.addObject("artifacts", artifactService.findAllLibrary());
        return modelAndView;
    }

}
