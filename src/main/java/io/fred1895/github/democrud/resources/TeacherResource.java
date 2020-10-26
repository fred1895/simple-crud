package io.fred1895.github.democrud.resources;

import model.dto.TeacherDto;
import model.services.TeacherService;
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
        TeacherDto teacherDto = teacherService.findTeacherDtoById(id);
        return ResponseEntity.ok().body(teacherDto);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllClients() {
        List<TeacherDto> teachers = teacherService.getAllTeachersDto();
        return ResponseEntity.ok().body(teachers);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody TeacherDto newTeacherDto) {
        teacherService.updateTeacher(id, newTeacherDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }

}
