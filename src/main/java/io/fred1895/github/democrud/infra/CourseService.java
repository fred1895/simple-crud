package io.fred1895.github.democrud.infra;

import io.fred1895.github.democrud.domain.entities.Course;
import io.fred1895.github.democrud.domain.entities.Student;
import io.fred1895.github.democrud.domain.entities.Teacher;
import io.fred1895.github.democrud.domain.dto.CourseDto;
import io.fred1895.github.democrud.domain.dto.StudentDto;
import io.fred1895.github.democrud.domain.dto.TeacherDto;
import io.fred1895.github.democrud.api.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CourseService {

    @Autowired
    private CourseDAO repository;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    public Course findCourseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Curso não encontrado"));
    }

    public CourseDto getCourseDtoById(Long id) {
        Course course = findCourseById(id);
        return toDto(course);
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

    public List<StudentDto> getStudentsFromCourse(Long id) {
        Course course = findCourseById(id);
        List<Student> students = course.getStudents();
        return studentService.listToDto(students);
    }

    public List<TeacherDto> getTeacherFromCourse(Long id) {
        Course course = findCourseById(id);
        List<Teacher> teachers = course.getTeachers();
        return teacherService.listToDto(teachers);
    }

    public void updateCourse(Long id, CourseDto newCourseDto) {
        Course course = findCourseById(id);
        updateData(course, newCourseDto);

        repository.save(course);
    }

    private void updateData(Course course, CourseDto newCourseDto) {
        if (newCourseDto.getDisciplina() != null) course.setDisciplina(newCourseDto.getDisciplina());
        if (newCourseDto.getDescricao() != null) course.setDescricao(newCourseDto.getDescricao());
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
}
