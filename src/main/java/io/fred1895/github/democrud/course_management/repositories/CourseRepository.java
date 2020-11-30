package io.fred1895.github.democrud.course_management.repositories;

import io.fred1895.github.democrud.course_management.entity.Course;
import io.fred1895.github.democrud.course_management.dto.CourseDto;
import io.fred1895.github.democrud.student_management.dto.StudentDto;
import io.fred1895.github.democrud.teacher_management.dto.TeacherDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseRepository {

    public void save(CourseDto courseDto);

    public List<CourseDto> findAll();

    public CourseDto findByIdDto(Long id);

    public Course findById(Long id);

    public List<TeacherDto> getTeachers(Long id);

    public List<StudentDto> getStudents(Long id);

    public void update(Long id, CourseDto newCourseDto);

    public void delete(Long id);

}
