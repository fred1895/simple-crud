package io.fred1895.github.democrud.course_management.controller;

import io.fred1895.github.democrud.domain.repositories.CourseRepository;
import io.fred1895.github.democrud.domain.dto.CourseDto;
import io.fred1895.github.democrud.domain.dto.StudentDto;
import io.fred1895.github.democrud.domain.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CourseResource {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody CourseDto course) {
        courseRepository.save(course);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long id) {
        CourseDto courseDto = courseRepository.findByIdDto(id);
        return ResponseEntity.ok().body(courseDto);
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getCourses() {
        List<CourseDto> allCourses = courseRepository.findAll();
        return ResponseEntity.ok().body(allCourses);
    }

    @GetMapping("/{id}/professores")
    public ResponseEntity<List<TeacherDto>> getTeachers(@PathVariable Long id) {
        List<TeacherDto> teachers = courseRepository.getTeachers(id);
        return ResponseEntity.ok().body(teachers);
    }

    @GetMapping("/{id}/estudantes")
    public ResponseEntity<List<StudentDto>> getStudents(@PathVariable Long id) {
        List<StudentDto> students = courseRepository.getStudents(id);
        return ResponseEntity.ok(students);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody CourseDto courseDto) {
        courseRepository.update(id, courseDto);
    }


}
