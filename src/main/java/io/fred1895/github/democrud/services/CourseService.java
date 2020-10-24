package io.fred1895.github.democrud.services;

import io.fred1895.github.democrud.domains.Course;
import io.fred1895.github.democrud.domains.Teacher;
import io.fred1895.github.democrud.dto.CourseDto;
import io.fred1895.github.democrud.dto.TeacherDto;
import io.fred1895.github.democrud.exceptions.ObjectNotFoundException;
import io.fred1895.github.democrud.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    @Autowired
    private TeacherService teacherService;

    public Course findCourseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Curso não encontrado"));
    }

    public void saveNewCourse(CourseDto courseDto) {
        Course course = courseFromDto(courseDto);
        repository.save(course);
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public List<CourseDto> getAllCoursesDto() {
        List<Course> courses = getAllCourses();
        return listToDto(courses);

    }

    public Course courseFromDto(CourseDto courseDto) {
        Course course = new Course();
        course.setDisciplina(courseDto.getDisciplina());
        course.setDescricao(courseDto.getDescricao());

        return course;
    }

    public CourseDto toDto(Course course) {
        return new CourseDto(course);
    }

    public List<CourseDto> listToDto(List<Course> courses) {
        return courses.stream().map(CourseDto::new).collect(toList());
    }

    public List<TeacherDto> getTeacherFromCourse(Long id) {
        Course course = findCourseById(id);
        List<Teacher> teachers = course.getTeachers();
        return teachers.stream().map(TeacherDto::new).collect(toList());
    }
}
