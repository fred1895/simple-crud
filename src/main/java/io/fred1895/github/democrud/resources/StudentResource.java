package io.fred1895.github.democrud.resources;

import io.fred1895.github.democrud.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alunos")
public class StudentResource {

    @Autowired
    private StudentService studentService;

}
