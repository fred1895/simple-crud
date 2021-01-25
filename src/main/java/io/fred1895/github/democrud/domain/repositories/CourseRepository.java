package io.fred1895.github.democrud.domain.repositories;

import io.fred1895.github.democrud.domain.entities.Course;
import io.fred1895.github.democrud.domain.dto.CourseDto;
import io.fred1895.github.democrud.domain.dto.StudentDto;
import io.fred1895.github.democrud.domain.dto.TeacherDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseRepository {

    void save(CourseDto courseDto);

    List<CourseDto> findAll();

    CourseDto findByIdDto(Long id);

    Course findById(Long id);

    List<TeacherDto> getTeachers(Long id);

    List<StudentDto> getStudents(Long id);

    void update(Long id, CourseDto newCourseDto);

    void delete(Long id);

}
