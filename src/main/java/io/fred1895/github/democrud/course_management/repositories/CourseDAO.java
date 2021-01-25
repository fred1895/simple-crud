package io.fred1895.github.democrud.course_management.repositories;

import io.fred1895.github.democrud.domain.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDAO extends JpaRepository<Course, Long> {

}
