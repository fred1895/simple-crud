package io.fred1895.github.democrud.student_management.controller;

import io.fred1895.github.democrud.domain.dto.StudentDto;
import io.fred1895.github.democrud.domain.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class StudentResource {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        StudentDto studentDto = studentRepository.findDtoById(id);
        return ResponseEntity.ok().body(studentDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody StudentDto studentDto) {
        studentRepository.save(studentDto);
    }

    @GetMapping
    public List<StudentDto> getStudents() {
        return studentRepository.findAllDto();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody StudentDto newStudentDto) {
        studentRepository.update(id, newStudentDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentRepository.delete(id);
    }
}
