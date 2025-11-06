package ru.volnenko.cloud.testhub.builder;

import lombok.NonNull;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;
import ru.volnenko.cloud.testhub.enumerated.ArtifactType;

public final class JacocoResultBuilder {

    @NonNull
    private final JacocoResultDto jacocoResultDto = new JacocoResultDto();

    @NonNull
    private final JacocoResultBuilder self = this;

    @NonNull
    public static JacocoResultBuilder create() {
        return new JacocoResultBuilder();
    }

    private JacocoResultBuilder() {
    }

    @NonNull
    public JacocoResultBuilder category(@NonNull final String category) {
        jacocoResultDto.getCategories().add(category);
        return this;
    }

    @NonNull
    public JacocoResultBuilder application() {
        jacocoResultDto.setType(ArtifactType.APPLICATION.toString());
        return this;
    }

    @NonNull
    public JacocoResultBuilder library() {
        jacocoResultDto.setType(ArtifactType.LIBRARY.toString());
        return this;
    }

    @NonNull
    public JacocoResultBuilder artifact(@NonNull final String artifact) {
        jacocoResultDto.setArtifactId(artifact);
        return this;
    }

    @NonNull
    public JacocoResultBuilder group(@NonNull final String group) {
        jacocoResultDto.setGroupId(group);
        return this;
    }

    @NonNull
    public JacocoResultBuilder version(@NonNull final String version) {
        jacocoResultDto.setVersion(version);
        return this;
    }

    @NonNull
    public JacocoResultBuilder branch(@NonNull final String branch) {
        jacocoResultDto.setBranch(branch);
        return this;
    }

    @NonNull
    public JacocoResultBuilder instructionMissed(final double instructionMissed) {
        jacocoResultDto.setInstructionMissed(instructionMissed);
        return this;
    }

    @NonNull
    public JacocoResultBuilder instructionCovered(final double instructionCovered) {
        jacocoResultDto.setInstructionCovered(instructionCovered);
        return this;
    }

    @NonNull
    public JacocoResultBuilder branchMissed(final double branchMissed) {
        jacocoResultDto.setBranchMissed(branchMissed);
        return this;
    }

    @NonNull
    public JacocoResultBuilder branchCovered(final double branchCovered) {
        jacocoResultDto.setBranchCovered(branchCovered);
        return this;
    }

    @NonNull
    public JacocoResultDto build() {
        return jacocoResultDto;
    }

}
