package io.fred1895.github.democrud.repositories;

import io.fred1895.github.democrud.domains.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
