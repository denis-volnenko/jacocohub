package ru.volnenko.cloud.testhub.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;

@Service
public class InitServiceBean implements InitService, Runnable {

    @Autowired
    private JacocoService jacocoService;

    @Autowired
    private JacocoResultService jacocoResultService;

    @Override
//    @PostConstruct
    public void init() {
        for (int i = 0; i < 15; i++) run();
    }

    @Override
    @Async
    public void run() {
        jacocoResultService.publish(core());
        jacocoResultService.publish(api());
        jacocoResultService.publish(worker());
    }

    @NonNull
    private JacocoResultDto worker() {
        return JacocoResultDto.create()
                .category("jacocohub")
                .group("ru.volnenko.cloud").artifact("jacocohub-worker").version("1.0.0").application()
                .build();
    }

    @NonNull
    private JacocoResultDto api() {
        return JacocoResultDto.create()
                .category("jacocohub")
                .group("ru.volnenko.cloud").artifact("jacocohub-api").version("1.0.0").application()
                .build();
    }

    @NonNull
    private JacocoResultDto core() {
        return JacocoResultDto.create()
                .category("jacocohub")
                .group("ru.volnenko.cloud").artifact("jacocohub-core").version("1.0.0").library()
                .build();
    }

    private float rand() {
        int min = 20;
        int max = 90;
        int randomInt = min + (int)(Math.random() * ((max - min) + 1));
        return randomInt;
    }

}
