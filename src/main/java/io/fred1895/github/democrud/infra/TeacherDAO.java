package io.fred1895.github.democrud.infra;

import io.fred1895.github.democrud.domain.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDAO extends JpaRepository<Teacher, Long> {

}
