package ru.volnenko.cloud.testhub.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.volnenko.cloud.testhub.model.Release;

public interface ReleaseRepository extends JpaRepository<Release, String> {

    Release findByArtifactIdAndVersionId(@NonNull String artifactId, @NonNull String versionId);

}
