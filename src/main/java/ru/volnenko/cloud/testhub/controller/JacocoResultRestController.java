package ru.volnenko.cloud.testhub.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;
import ru.volnenko.cloud.testhub.dto.ResultDto;

@RequestMapping("/api/result/jacoco")
public interface JacocoResultRestController {

    @Operation(summary = "Публикация результатов Jacoco", description = "Публикация результатов Jacoco")
    @ApiResponse(responseCode = "200", description = "Успешное выполнение")
    @ApiResponse(responseCode = "500", description = "Выполнено с ошибкой")
    @GetMapping("/greet/{name}")
    @PostMapping(value = "/publish", produces = "application/json", consumes = "application/json")
    ResultDto publish(@NonNull JacocoResultDto result);

}
