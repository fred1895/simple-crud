package io.fred1895.github.democrud.infra;

import io.fred1895.github.democrud.domain.entities.Course;
import io.fred1895.github.democrud.domain.repositories.CourseRepository;
import io.fred1895.github.democrud.domain.repositories.StudentRepository;
import io.fred1895.github.democrud.api.ObjectNotFoundException;
import io.fred1895.github.democrud.domain.dto.StudentDto;
import io.fred1895.github.democrud.domain.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static io.fred1895.github.democrud.infra.StudentUtil.*;

public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    private StudentDAO dao;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void save(StudentDto studentDto) {
        Course course = courseRepository.findById(studentDto.getIdCurso());
        Student student = studentFromDto(studentDto);
        student.setCourse(course);
        dao.save(student);
    }

    @Override
    public Student findById(Long id) {
        return dao.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Estudante não encontrado"));
    }

    @Override
    public StudentDto findDtoById(Long id) {
        Student student = findById(id);
        return studentToDto(student);
    }

    @Override
    public List<Student> findAll() {
        return dao.findAll();
    }

    @Override
    public List<StudentDto> findAllDto() {
        List<Student> students = findAll();
        return studentListToDto(students);
    }

    @Override
    public void update(Long id, StudentDto studentDto) {
        Student student = findById(id);
        studentUpdateData(student, studentDto);
        dao.save(student);
    }

    @Override
    public void delete(Long id) {
        Student student = findById(id);
        dao.delete(student);
    }
}
