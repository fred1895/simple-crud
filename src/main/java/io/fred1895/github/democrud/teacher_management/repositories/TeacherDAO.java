package io.fred1895.github.democrud.teacher_management.repositories;

import io.fred1895.github.democrud.teacher_management.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDAO extends JpaRepository<Teacher, Long> {

}
