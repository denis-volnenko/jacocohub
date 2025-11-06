package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;
import ru.volnenko.cloud.testhub.model.Jacoco;

import java.util.Date;

@Service
public interface JacocoResultService {

    @NonNull
    Jacoco publish(@NonNull JacocoResultDto result);

    @NonNull
    Jacoco publish(@NonNull JacocoResultDto result, @NonNull Date date);

}
