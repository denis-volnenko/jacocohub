package ru.volnenko.cloud.testhub.builder;

import lombok.NonNull;
import ru.volnenko.cloud.testhub.dto.JacocoResultDto;

public final class JacocoResultBuilder {

    @NonNull
    private final JacocoResultDto jacocoResultDto = new JacocoResultDto();

    @NonNull
    private final JacocoResultParentBuilder parentBuilder = new JacocoResultParentBuilder();

    @NonNull
    private final JacocoResultBuilder self = this;

    @NonNull
    public static JacocoResultBuilder create() {
        return new JacocoResultBuilder();
    }

    public class JacocoResultParentBuilder {

        @NonNull
        public JacocoResultParentBuilder artifact(@NonNull final String artifact) {
            jacocoResultDto.setParentArtifact(artifact);
            return this;
        }

        @NonNull
        public JacocoResultParentBuilder group(@NonNull final String group) {
            jacocoResultDto.setParentGroup(group);
            return this;
        }

        @NonNull
        public JacocoResultParentBuilder version(@NonNull final String version) {
            jacocoResultDto.setParentVersion(version);
            return this;
        }

        @NonNull
        public JacocoResultBuilder builder() {
            return self;
        }

        @NonNull
        public JacocoResultDto build() {
            return self.build();
        }

    }

    private JacocoResultBuilder() {
    }

    @NonNull
    public JacocoResultParentBuilder parent() {
        return parentBuilder;
    }

    @NonNull
    public JacocoResultBuilder artifact(@NonNull final String artifact) {
        jacocoResultDto.setArtifact(artifact);
        return this;
    }

    @NonNull
    public JacocoResultBuilder group(@NonNull final String group) {
        jacocoResultDto.setGroup(group);
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
    public JacocoResultBuilder branches(@NonNull final Float branches) {
        jacocoResultDto.setBranches(branches);
        return this;
    }

    @NonNull
    public JacocoResultBuilder instructions(@NonNull final Float instructions) {
        jacocoResultDto.setInstructions(instructions);
        return this;
    }

    @NonNull
    public JacocoResultDto build() {
        return jacocoResultDto;
    }

}
