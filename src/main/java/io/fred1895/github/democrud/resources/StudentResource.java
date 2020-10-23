package io.fred1895.github.democrud.resources;

import io.fred1895.github.democrud.dto.StudentDto;
import io.fred1895.github.democrud.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alunos")
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody StudentDto studentDto) {
        studentService.saveStudent(studentDto);
    }
}
