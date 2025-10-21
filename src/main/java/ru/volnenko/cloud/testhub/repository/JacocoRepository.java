package ru.volnenko.cloud.testhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.volnenko.cloud.testhub.model.Jacoco;

import java.util.List;

public interface JacocoRepository extends JpaRepository<Jacoco, String> {

    @Query("SELECT j FROM Jacoco j WHERE j.artifactId = :artifactId ORDER BY j.created DESC")
    List<Jacoco> findAllByArtifactId(@Param("artifactId") String artifactId);

}
