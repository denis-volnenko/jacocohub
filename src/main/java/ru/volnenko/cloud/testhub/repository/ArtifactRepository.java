package ru.volnenko.cloud.testhub.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.volnenko.cloud.testhub.model.Artifact;

import java.util.List;

public interface ArtifactRepository extends JpaRepository<Artifact, String> {

    @Query("SELECT a FROM Artifact a JOIN Path p ON a.id = p.childId WHERE p.parentId = :parentId")
    List<Artifact> findAllChildren(@Param("parentId") String parentId);

    @NonNull
    @Query("SELECT e FROM Artifact e ORDER BY e.name")
    List<Artifact> findAllArtifact();

    @NonNull
    @Query("SELECT e FROM Artifact e WHERE e.type = 'APPLICATION' ORDER BY e.name")
    List<Artifact> findAllApplication();

    @NonNull
    @Query("SELECT e FROM Artifact e WHERE e.type = 'LIBRARY' ORDER BY e.name")
    List<Artifact> findAllLibrary();

    Artifact findByName(@NonNull String name);

    Artifact findByNameAndGroupId(@NonNull String name, @NonNull String groupId);

}
