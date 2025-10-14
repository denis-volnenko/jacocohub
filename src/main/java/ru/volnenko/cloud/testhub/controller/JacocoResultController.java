package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;
import ru.volnenko.cloud.testhub.dto.ResultDto;

@Controller
@RequestMapping("/api/result/jacoco")
public interface JacocoResultController {

    @PostMapping(value = "/publish", produces = "application/json", consumes = "application/json")
    ResultDto publish(@NonNull JacocoResultDto result);

}
