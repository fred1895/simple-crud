package io.fred1895.github.democrud.student_management.repositories;

import io.fred1895.github.democrud.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, Long> {

}
