package io.fred1895.github.democrud.resources;

import io.fred1895.github.democrud.dto.CourseDto;
import io.fred1895.github.democrud.dto.TeacherDto;
import io.fred1895.github.democrud.services.CourseService;
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

    @GetMapping("/lista")
    public ResponseEntity<List<CourseDto>> getCourses() {
        List<CourseDto> allCourses = service.getAllCoursesDto();
        return ResponseEntity.ok().body(allCourses);
    }

    @GetMapping("/{id}/professores")
    public ResponseEntity<List<TeacherDto>> getTeachers(@PathVariable Long id) {
        List<TeacherDto> teachers = service.getTeacherFromCourse(id);
        return ResponseEntity.ok().body(teachers);
    }

}
