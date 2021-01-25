package io.fred1895.github.democrud.student_management;

import io.fred1895.github.democrud.course_management.CourseService;
import io.fred1895.github.democrud.domain.entities.Course;
import io.fred1895.github.democrud.resources.exceptions.ObjectNotFoundException;
import io.fred1895.github.democrud.domain.dto.StudentDto;
import io.fred1895.github.democrud.domain.entities.Student;
import io.fred1895.github.democrud.student_management.repositories.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class StudentService {

    @Autowired
    private StudentDAO dao;

    @Autowired
    private CourseService courseRepository;

    public Student getStudentById(Long id) {
        return dao.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Estudante não encontrado"));
    }

    public StudentDto getStudentDtoById(Long id) {
        Student student = getStudentById(id);
        return toDto(student);
    }

    public void saveStudent(StudentDto studentDto) {
        Course course = courseRepository.findCourseById(studentDto.getIdCurso());
        Student student = fromDto(studentDto);
        student.setCourse(course);
        dao.save(student);
    }

    public List<Student> getAllStudents() {
        return dao.findAll();
    }

    public List<StudentDto> getAllStudentsDto() {
        List<Student> students = getAllStudents();
        return listToDto(students);
    }


    public void updateStudent(Long id, StudentDto newStudentDto) {
        Student student = getStudentById(id);
        updateData(student, newStudentDto);
        dao.save(student);
    }

    private void updateData(Student student, StudentDto newStudentDto) {
        if (newStudentDto.getNome() != null) student.setNome(newStudentDto.getNome());
        if (newStudentDto.getEmail() != null) student.setEmail(newStudentDto.getEmail());
        if (newStudentDto.getIdade() != null) student.setIdade(newStudentDto.getIdade());
    }

    public Student fromDto(StudentDto studentDto) {
        Student student = new Student();
        student.setNome(studentDto.getNome());
        student.setEmail(studentDto.getEmail());
        student.setIdade(studentDto.getIdade());

        return student;
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        dao.delete(student);
    }

    public StudentDto toDto(Student student) {
        return new StudentDto(student);
    }

    public List<StudentDto> listToDto(List<Student> students) {
        return students.stream().map(StudentDto::new).collect(toList());
    }
}
