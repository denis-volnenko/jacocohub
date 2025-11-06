package ru.volnenko.cloud.testhub.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.volnenko.cloud.testhub.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Category findByName(@NonNull String name);

}
