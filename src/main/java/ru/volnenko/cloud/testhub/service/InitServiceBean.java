package ru.volnenko.cloud.testhub.service;

import jakarta.annotation.PostConstruct;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;

@Service
public class InitServiceBean implements InitService {

    @Autowired
    private JacocoService jacocoService;

    @Autowired
    private JacocoResultService jacocoResultService;

    @Override
    @PostConstruct
    public void init() {
        for (int i = 0; i < 20; i++) {
            jacocoResultService.publish(core());
            jacocoResultService.publish(api());
            jacocoResultService.publish(worker());
        }
    }

    @NonNull
    private JacocoResultDto worker() {
        return JacocoResultDto.create()
                .group("ru.volnenko.cloud").artifact("testhub-worker").version("1.0.0").application()
                .parent().group("ru.volnenko.cloud").artifact("testhub-app").version("1.0.0").builder()
                .branches(rand()).instructions(rand())
                .build();
    }

    @NonNull
    private JacocoResultDto api() {
        return JacocoResultDto.create()
                .group("ru.volnenko.cloud").artifact("testhub-api").version("1.0.0").application()
                .parent().group("ru.volnenko.cloud").artifact("testhub-app").version("1.0.0").builder()
                .branches(rand()).instructions(rand())
                .build();
    }

    @NonNull
    private JacocoResultDto core() {
        return JacocoResultDto.create()
                .group("ru.volnenko.cloud").artifact("testhub-core").version("1.0.0").library()
                .parent().group("ru.volnenko.cloud").artifact("testhub-app").version("1.0.0").builder()
                .branches(rand()).instructions(rand())
                .build();
    }

    private float rand() {
        int min = 20;
        int max = 90;
        int randomInt = min + (int)(Math.random() * ((max - min) + 1));
        return randomInt;
    }

}
