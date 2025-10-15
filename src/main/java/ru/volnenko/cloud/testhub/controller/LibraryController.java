package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public interface LibraryController {

    @NonNull
    @GetMapping("/ui/libraries")
    ModelAndView libraries();

}
