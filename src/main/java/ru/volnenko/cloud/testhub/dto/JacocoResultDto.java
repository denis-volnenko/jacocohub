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
    private String parentType = ArtifactType.APPLICATION.toString();

    @NonNull
    private String group = "";

    @NonNull
    private String type = ArtifactType.APPLICATION.toString();

    @NonNull
    private String branch = "master";

    @NonNull
    private String artifact = "";

    @NonNull
    private String version = "";

    private double instructionMissed = 0;

    private double instructionCovered = 0;

    private double branchMissed = 0;

    private double branchCovered = 0;

    private double lineMissed = 0;

    private double lineCovered = 0;

    private double complexityMissed = 0;

    private double complexityCovered = 0;

    private double methodMissed = 0;

    private double methodCovered = 0;

    private double classMissed = 0;

    private double classCovered = 0;

}
