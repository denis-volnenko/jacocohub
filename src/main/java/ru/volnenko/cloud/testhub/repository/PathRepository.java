package ru.volnenko.cloud.testhub.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.volnenko.cloud.testhub.model.Path;

public interface PathRepository extends JpaRepository<Path, String> {

    @Query("SELECT e FROM Path e WHERE e.parentId = :parentId AND e.childId = :childId")
    Path findOne(@Param("parentId") @NonNull String parentId, @Param("childId") @NonNull String childId);

}
