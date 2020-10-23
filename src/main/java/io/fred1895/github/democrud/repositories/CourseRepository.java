package io.fred1895.github.democrud.repositories;

import io.fred1895.github.democrud.domains.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
