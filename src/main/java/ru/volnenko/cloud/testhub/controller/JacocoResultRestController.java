package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;
import ru.volnenko.cloud.testhub.dto.ResultDto;

@RestController
@RequestMapping("/api/result/jacoco")
public interface JacocoResultRestController {

    @PostMapping(value = "/publish", produces = "application/json", consumes = "application/json")
    ResultDto publish(@NonNull JacocoResultDto result);

}
