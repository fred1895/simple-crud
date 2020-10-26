package io.fred1895.github.democrud.model.repositories;

import io.fred1895.github.democrud.model.domains.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
