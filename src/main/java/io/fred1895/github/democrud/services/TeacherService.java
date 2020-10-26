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
    private TeacherRepository repository;

    @Autowired
    private CourseService courseService;

    public void saveTeacher(TeacherDto teacherDto) {
        Course course = courseService.findCourseById(teacherDto.getIdCurso());
        Teacher teacher = teacherFromDto(teacherDto);
        teacher.setCourse(course);
        repository.save(teacher);
    }

    public Teacher findTeacherById(Long id) {
        return repository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("Professor não encontrado") );
    }

    public TeacherDto findTeacherDtoById(Long id) {
        Teacher teacher = findTeacherById(id);
        return toDto(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return repository.findAll();
    }

    public List<TeacherDto> getAllTeachersDto() {
        List<Teacher> teacherList = getAllTeachers();
        return listToDto(teacherList);
    }

    public Teacher teacherFromDto(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setNome(teacherDto.getNome());
        teacher.setCpf(teacherDto.getCpf());

        return teacher;
    }

    public TeacherDto toDto(Teacher teacher) {
        return new TeacherDto(teacher);
    }

    public List<TeacherDto> listToDto(List<Teacher> teachers) {
        return teachers.stream().map(TeacherDto::new).collect(toList());
    }

    public void updateTeacher(Long id, Teacher newTeacher) {
        Teacher teacher = findTeacherById(id);
        if (newTeacher.getNome() != null) teacher.setNome(newTeacher.getNome());
        if (newTeacher.getCpf() != null) teacher.setCpf(newTeacher.getCpf());

        repository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        Teacher teacher = findTeacherById(id);
        repository.delete(teacher);
    }
}
