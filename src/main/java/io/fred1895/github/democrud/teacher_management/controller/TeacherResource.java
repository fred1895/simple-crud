package io.fred1895.github.democrud.teacher_management.controller;

import io.fred1895.github.democrud.domain.dto.TeacherDto;
import io.fred1895.github.democrud.domain.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
public class TeacherResource {

    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveClient(@RequestBody TeacherDto teacher) {
        teacherRepository.save(teacher);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> findById(@PathVariable Long id) {
        TeacherDto teacherDto = teacherRepository.findDtoById(id);
        return ResponseEntity.ok().body(teacherDto);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllClients() {
        List<TeacherDto> teachers = teacherRepository.findAll();
        return ResponseEntity.ok().body(teachers);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody TeacherDto newTeacherDto) {
        teacherRepository.update(id, newTeacherDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        teacherRepository.delete(id);
    }

}
