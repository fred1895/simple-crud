package io.fred1895.github.democrud.student_management.repositories;

import io.fred1895.github.democrud.student_management.dto.StudentDto;
import io.fred1895.github.democrud.student_management.entity.Student;
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
