package ru.volnenko.cloud.testhub.builder;

import lombok.NonNull;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;

public final class JacocoResultBuilder {

    @NonNull
    private JacocoResultDto jacocoResultDto = new JacocoResultDto();

    @NonNull
    public static JacocoResultBuilder create() {
        return new JacocoResultBuilder();
    }

    private JacocoResultBuilder() {
    }

    @NonNull
    public JacocoResultDto build() {
        return jacocoResultDto;
    }

}
