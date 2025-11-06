package ru.volnenko.cloud.testhub.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.cloud.testhub.builder.JacocoResultBuilder;
import ru.volnenko.cloud.testhub.enumerated.ArtifactType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public final class JacocoResultDto {

    @NonNull
    public static JacocoResultBuilder create() {
        return JacocoResultBuilder.create();
    }

    @NonNull
    @JsonProperty("groupId")
    private String groupId = "";

    @NonNull
    @JsonProperty("type")
    private String type = ArtifactType.APPLICATION.toString();

    @NonNull
    @JsonProperty("branch")
    private String branch = "master";

    @NonNull
    @JsonProperty("artifactId")
    private String artifactId = "";

    @NonNull
    @JsonProperty("version")
    private String version = "";

    @JsonProperty("instructionMissed")
    private double instructionMissed = 0;

    @JsonProperty("instructionCovered")
    private double instructionCovered = 0;

    @JsonProperty("branchMissed")
    private double branchMissed = 0;

    @JsonProperty("branchCovered")
    private double branchCovered = 0;

    @JsonProperty("lineMissed")
    private double lineMissed = 0;

    @JsonProperty("lineCovered")
    private double lineCovered = 0;

    @JsonProperty("complexityMissed")
    private double complexityMissed = 0;

    @JsonProperty("complexityCovered")
    private double complexityCovered = 0;

    @JsonProperty("methodMissed")
    private double methodMissed = 0;

    @JsonProperty("methodCovered")
    private double methodCovered = 0;

    @JsonProperty("classMissed")
    private double classMissed = 0;

    @JsonProperty("classCovered")
    private double classCovered = 0;

    @NonNull
    private List<String> categories = new ArrayList<>();

}
