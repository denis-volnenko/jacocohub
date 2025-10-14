package ru.volnenko.cloud.testhub.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;
import ru.volnenko.cloud.testhub.dto.ResultDto;
import ru.volnenko.cloud.testhub.service.JacocoResultServiceBean;

@Controller
@RequestMapping("/api/result/jacoco")
public class JacocoResultControllerBean implements JacocoResultController {

    @Autowired
    private JacocoResultServiceBean jacocoResultService;

    @PostMapping(value = "/publish", produces = "application/json", consumes = "application/json")
    public ResultDto publish(@NonNull final JacocoResultDto result) {
        try {
            jacocoResultService.publish(result);
        } catch (@NonNull final Exception e) {
            return new ResultDto(e);
        }
        return new ResultDto();
    }

}
