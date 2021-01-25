package io.fred1895.github.democrud.domain.repositories;

import io.fred1895.github.democrud.domain.dto.StudentDto;
import io.fred1895.github.democrud.domain.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentRepository {

    void save(StudentDto studentDto);

    Student findById(Long id);

    StudentDto findDtoById(Long id);

    List<Student> findAll();

    List<StudentDto> findAllDto();

    void update(Long id, StudentDto studentDto);

    void delete(Long id);

}
