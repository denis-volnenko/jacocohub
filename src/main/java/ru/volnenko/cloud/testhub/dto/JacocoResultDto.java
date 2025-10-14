package ru.volnenko.cloud.testhub.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.cloud.testhub.builder.JacocoResultBuilder;
import ru.volnenko.cloud.testhub.enumerated.ArtifactType;

@Getter
@Setter
public final class JacocoResultDto {

    @NonNull
    public static JacocoResultBuilder create() {
        return JacocoResultBuilder.create();
    }

    @NonNull
    private String parentGroup = "";

    @NonNull
    private String parentArtifact = "";

    @NonNull
    private String parentVersion = "";

    @NonNull
    private String group = "";

    @NonNull
    private String type = ArtifactType.APPLICATION.toString();

    @NonNull
    private String branch = "";

    @NonNull
    private String artifact = "";

    @NonNull
    private String version = "";

    @NonNull
    private Float branches = 0F;

    @NonNull
    private Float instructions = 0F;

}
