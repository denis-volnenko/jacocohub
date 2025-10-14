package ru.volnenko.cloud.testhub.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public final class JacocoResultDto {

    @NonNull
    private String parentGroup = "";

    @NonNull
    private String parentArtifact = "";

    @NonNull
    private String parentVersion = "";

    @NonNull
    private String group = "";

    @NonNull
    private String artifact = "";

    @NonNull
    private String version = "";

    @NonNull
    private Double branches = 0D;

    @NonNull
    private Double instructions = 0D;

}
