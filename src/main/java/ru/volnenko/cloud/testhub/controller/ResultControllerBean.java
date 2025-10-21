package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.volnenko.cloud.testhub.service.JacocoService;

@Controller
public final class ResultControllerBean implements ResultController {

    @Autowired
    private JacocoService jacocoService;

    @NonNull
    @Override
    @GetMapping("/ui/result/{id}")
    public ModelAndView result(@PathVariable("id") @NonNull final String id) {
        @NonNull final ModelAndView modelAndView = new ModelAndView("result");
        return modelAndView;
    }

}
