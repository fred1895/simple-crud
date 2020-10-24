package io.fred1895.github.democrud.resources;

import io.fred1895.github.democrud.dto.StudentDto;
import io.fred1895.github.democrud.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        StudentDto studentDto = studentService.getStudentDtoById(id);
        return ResponseEntity.ok().body(studentDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody StudentDto studentDto) {
        studentService.saveStudent(studentDto);
    }

    @GetMapping("/lista")
    public List<StudentDto> getStudents() {
        return studentService.getAllStudentsDto();
    }
}
