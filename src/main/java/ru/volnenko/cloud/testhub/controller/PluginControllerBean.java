package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public final class PluginControllerBean implements PluginController {

    @NonNull
    @Override
    @GetMapping("/ui/plugin")
    public ModelAndView plugin() {
        return new ModelAndView("plugin");
    }

}
