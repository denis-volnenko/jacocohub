package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.volnenko.cloud.testhub.service.JacocoService;

@Controller
public class IndexControllerBean implements IndexController {

    @Autowired
    private JacocoService jacocoService;

    @Autowired
    private ArtifactController artifactController;

    @Override
    @NonNull
    @GetMapping("/")
    public ModelAndView index() {
        return artifactController.artifacts();
    }

}
