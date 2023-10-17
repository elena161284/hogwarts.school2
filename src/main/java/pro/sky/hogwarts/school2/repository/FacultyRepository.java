package pro.sky.hogwarts.school2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.hogwarts.school2.model.Faculty;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findAllByColor(String color);

    Collection<Faculty> findAllByNameOrColorIgnoreCase(String name, String color);
}