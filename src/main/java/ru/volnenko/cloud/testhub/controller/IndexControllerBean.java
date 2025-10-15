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

    @Override
    @NonNull
    @GetMapping("/")
    public ModelAndView index() {
        @NonNull final ModelAndView result = new ModelAndView();
        result.setViewName("index");
        return result;
    }

}
