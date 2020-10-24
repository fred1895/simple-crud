package io.fred1895.github.democrud.services;

import io.fred1895.github.democrud.domains.Course;
import io.fred1895.github.democrud.domains.Student;
import io.fred1895.github.democrud.dto.StudentDto;
import io.fred1895.github.democrud.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private CourseService courseService;

    public void saveStudent(StudentDto studentDto) {
        Course course = courseService.findCourseById(studentDto.getIdCurso());
        Student student = fromDto(studentDto);
        student.setCourse(course);
        repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public List<StudentDto> getAllStudentsDto() {
        List<Student> students = getAllStudents();
        return listToDto(students);
    }

    public Student fromDto(StudentDto studentDto) {
        Student student = new Student();
        student.setNome(studentDto.getNome());
        student.setEmail(studentDto.getEmail());
        student.setIdade(studentDto.getIdade());

        return student;
    }

    public List<StudentDto> listToDto(List<Student> students) {
        return students.stream().map(StudentDto::new).collect(toList());
    }



}
