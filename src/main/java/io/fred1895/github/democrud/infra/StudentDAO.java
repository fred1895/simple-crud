package io.fred1895.github.democrud.infra;

import io.fred1895.github.democrud.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, Long> {

}
