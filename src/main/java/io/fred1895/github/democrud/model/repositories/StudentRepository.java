package io.fred1895.github.democrud.model.repositories;

import io.fred1895.github.democrud.model.domains.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
