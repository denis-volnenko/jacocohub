package ru.volnenko.cloud.testhub.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.volnenko.cloud.testhub.model.Version;

public interface VersionRepository extends JpaRepository<Version, String> {

    Version findByName(@NonNull String name);

}
