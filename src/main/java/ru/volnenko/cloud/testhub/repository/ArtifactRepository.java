package ru.volnenko.cloud.testhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.volnenko.cloud.testhub.model.Artifact;

public interface ArtifactRepository extends JpaRepository<String, Artifact> {

}
