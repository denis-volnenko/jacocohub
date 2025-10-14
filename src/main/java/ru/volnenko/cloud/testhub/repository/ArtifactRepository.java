package ru.volnenko.cloud.testhub.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.volnenko.cloud.testhub.model.Artifact;

public interface ArtifactRepository extends JpaRepository<Artifact, String> {

    Artifact findByName(@NonNull String name);

    Artifact findByNameAndGroupId(@NonNull String name, @NonNull String groupId);

}
