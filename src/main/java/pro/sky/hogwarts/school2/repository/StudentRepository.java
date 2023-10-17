package pro.sky.hogwarts.school2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.hogwarts.school2.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findAllByAge(int age);

    Collection<Student> findAllByName(String name);

    Collection<Student> findAllByAgeBetween(int min, int max);
}