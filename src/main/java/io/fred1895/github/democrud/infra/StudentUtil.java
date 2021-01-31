package io.fred1895.github.democrud.infra;

import io.fred1895.github.democrud.domain.dto.StudentDto;
import io.fred1895.github.democrud.domain.entities.Student;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StudentUtil {

    public static StudentDto studentToDto(Student student) {
        return new StudentDto(student);
    }

    public static List<StudentDto> studentListToDto(List<Student> students) {
        return students.stream().map(StudentDto::new).collect(toList());
    }

    public static Student studentFromDto(StudentDto studentDto) {
        Student student = new Student();
        student.setNome(studentDto.getNome());
        student.setEmail(studentDto.getEmail());
        student.setIdade(studentDto.getIdade());

        return student;
    }

    public static void studentUpdateData(Student student, StudentDto newStudentDto) {
        if (newStudentDto.getNome() != null) student.setNome(newStudentDto.getNome());
        if (newStudentDto.getEmail() != null) student.setEmail(newStudentDto.getEmail());
        if (newStudentDto.getIdade() != null) student.setIdade(newStudentDto.getIdade());
    }

}
