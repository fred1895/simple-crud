package io.fred1895.github.democrud.resources;

import model.dto.CourseDto;
import model.dto.StudentDto;
import model.dto.TeacherDto;
import model.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CourseResource {

    @Autowired
    private CourseService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody CourseDto course) {
        service.saveNewCourse(course);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long id) {
        CourseDto courseDto = service.getCourseDtoById(id);
        return ResponseEntity.ok().body(courseDto);
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getCourses() {
        List<CourseDto> allCourses = service.getAllCoursesDto();
        return ResponseEntity.ok().body(allCourses);
    }

    @GetMapping("/{id}/professores")
    public ResponseEntity<List<TeacherDto>> getTeachers(@PathVariable Long id) {
        List<TeacherDto> teachers = service.getTeacherFromCourse(id);
        return ResponseEntity.ok().body(teachers);
    }

    @GetMapping("/{id}/estudantes")
    public ResponseEntity<List<StudentDto>> getStudents(@PathVariable Long id) {
        List<StudentDto> students = service.getStudentsFromCourse(id);
        return ResponseEntity.ok(students);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody CourseDto courseDto) {
        service.updateCourse(id, courseDto);
    }


}
