package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;
import ru.volnenko.cloud.testhub.dto.ResultDto;

@RequestMapping("/api/result/jacoco")
public class JacocoResultController {

    @PostMapping(value = "/publish", produces = "application/json", consumes = "application/json")
    public ResultDto publish(@NonNull final JacocoResultDto result) {
        return new ResultDto();
    }

}
