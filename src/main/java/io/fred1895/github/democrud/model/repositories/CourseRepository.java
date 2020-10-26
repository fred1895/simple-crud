package io.fred1895.github.democrud.model.repositories;

import io.fred1895.github.democrud.model.domains.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
