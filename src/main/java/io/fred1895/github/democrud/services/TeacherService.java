package io.fred1895.github.democrud.services;

import io.fred1895.github.democrud.domains.Course;
import io.fred1895.github.democrud.domains.Teacher;
import io.fred1895.github.democrud.dto.TeacherDto;
import io.fred1895.github.democrud.exceptions.ObjectNotFoundException;
import io.fred1895.github.democrud.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseService courseService;

    public void saveTeacher(TeacherDto teacherDto) {
        Course course = courseService.findCourseById(teacherDto.getIdCurso());
        Teacher teacher = teacherFromDto(teacherDto);
        teacher.setCourse(course);
        teacherRepository.save(teacher);
    }

    public List<TeacherDto> getTeachers() {
        List<Teacher> teacherList = teacherRepository.findAll();
        return teacherList.stream().map(TeacherDto::new).collect(toList());
    }

    public TeacherDto findTeacherById(Long id) {
        Optional<Teacher> clientOptional = teacherRepository.findById(id);
        Teacher teacher = clientOptional.
                orElseThrow(() -> new ObjectNotFoundException("Cliente com id: " + id + " não encontrado"));
        return new TeacherDto(teacher);
    }

    public Teacher teacherFromDto(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setNome(teacherDto.getNome());
        teacher.setCpf(teacherDto.getCpf());

        return teacher;
    }
}
