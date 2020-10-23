package io.fred1895.github.democrud.resources;

import io.fred1895.github.democrud.domains.Course;
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
    private CourseService courseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Course course) {
        courseService.saveNewCourse(course);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        List<Course> allCourses = courseService.getAllCourses();
        return ResponseEntity.ok().body(allCourses);
    }

}
