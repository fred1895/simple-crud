package io.fred1895.github.democrud.student_management.repositories;

import io.fred1895.github.democrud.course_management.entity.Course;
import io.fred1895.github.democrud.course_management.repositories.CourseRepository;
import io.fred1895.github.democrud.resources.exceptions.ObjectNotFoundException;
import io.fred1895.github.democrud.student_management.dto.StudentDto;
import io.fred1895.github.democrud.student_management.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static io.fred1895.github.democrud.student_management.utils.StudentUtil.*;

public class StudentRepositoryImpl implements StudentRepository{
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
