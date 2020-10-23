package io.fred1895.github.democrud.resources;

import io.fred1895.github.democrud.dto.TeacherDto;
import io.fred1895.github.democrud.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
public class TeacherResource {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveClient(@RequestBody TeacherDto teacher) {
        teacherService.saveTeacher(teacher);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> findById(@PathVariable Long id) {
        TeacherDto teacher = teacherService.findTeacherById(id);
        return ResponseEntity.ok().body(teacher);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllClients() {
        List<TeacherDto> teachers = teacherService.getTeachers();
        return ResponseEntity.ok().body(teachers);
    }
}
