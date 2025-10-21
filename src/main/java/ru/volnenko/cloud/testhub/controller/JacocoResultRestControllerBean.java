package ru.volnenko.cloud.testhub.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;
import ru.volnenko.cloud.testhub.dto.ResultDto;
import ru.volnenko.cloud.testhub.service.JacocoResultServiceBean;

@RestController
@RequestMapping("/api/v1/result/jacoco")
public class JacocoResultRestControllerBean implements JacocoResultRestController {

    @Autowired
    private JacocoResultServiceBean jacocoResultService;

    @Operation(summary = "Публикация результатов Jacoco", description = "Публикация результатов Jacoco")
    @ApiResponse(responseCode = "200", description = "Успешное выполнение")
    @ApiResponse(responseCode = "500", description = "Выполнено с ошибкой")
    @PostMapping(value = "/publish", produces = "application/json", consumes = "application/json")
    public ResultDto publish(@RequestBody @NonNull final JacocoResultDto result) {
        System.out.println("PUBLISH");
        try {
            jacocoResultService.publish(result);
        } catch (@NonNull final Exception e) {
            return new ResultDto(e);
        }
        return new ResultDto();
    }

}
