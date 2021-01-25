package io.fred1895.github.democrud.course_management.repositories;

import io.fred1895.github.democrud.domain.entities.Course;
import io.fred1895.github.democrud.domain.entities.Student;
import io.fred1895.github.democrud.domain.entities.Teacher;
import io.fred1895.github.democrud.domain.dto.CourseDto;
import io.fred1895.github.democrud.domain.dto.StudentDto;
import io.fred1895.github.democrud.domain.dto.TeacherDto;
import io.fred1895.github.democrud.domain.repositories.CourseRepository;
import io.fred1895.github.democrud.student_management.StudentService;
import io.fred1895.github.democrud.teacher_management.TeacherService;
import io.fred1895.github.democrud.resources.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.fred1895.github.democrud.course_management.utils.ConverterUtil.*;

@Service
public class CourseRepositoryImpl implements CourseRepository {
    @Autowired
    private CourseDAO dao;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Override
    public void save(CourseDto courseDto) {
        Course course = courseFromDto(courseDto);
        dao.save(course);
    }

    @Override
    public List<CourseDto> findAll() {
        List<Course> courses = dao.findAll();
        return listCourseToDto(courses);
    }

    @Override
    public CourseDto findByIdDto(Long id) {
        Course course = dao.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Curso não encontrado"));
        return courseToDto(course);
    }

    @Override
    public Course findById(Long id) {
        return dao.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Curso não encontrado"));
    }

    @Override
    public List<TeacherDto> getTeachers(Long id) {
        Course course = findById(id);
        List<Teacher> teachers = course.getTeachers();
        return teacherService.listToDto(teachers);
    }

    @Override
    public List<StudentDto> getStudents(Long id) {
        Course course = findById(id);
        List<Student> students = course.getStudents();
        return studentService.listToDto(students);
    }

    @Override
    public void update(Long id, CourseDto newCourseDto) {
        Course course = findById(id);
        updateCourseData(course, newCourseDto);

        dao.save(course);
    }

    @Override
    public void delete(Long id) {

    }

}
