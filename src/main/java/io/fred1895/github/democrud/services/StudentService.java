package io.fred1895.github.democrud.services;

import io.fred1895.github.democrud.domains.Student;
import io.fred1895.github.democrud.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;


}
