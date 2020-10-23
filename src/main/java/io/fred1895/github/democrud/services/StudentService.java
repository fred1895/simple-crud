package io.fred1895.github.democrud.services;

import io.fred1895.github.democrud.domains.Course;
import io.fred1895.github.democrud.domains.Student;
import io.fred1895.github.democrud.dto.StudentDto;
import io.fred1895.github.democrud.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Student fromDto(StudentDto studentDto) {
        Student student = new Student();
        student.setNome(studentDto.getNome());
        student.setEmail(studentDto.getEmail());
        student.setIdade(studentDto.getIdade());

        return student;
    }



}
