package io.fred1895.github.democrud.model.services;

import io.fred1895.github.democrud.model.domains.Course;
import io.fred1895.github.democrud.model.domains.Teacher;
import io.fred1895.github.democrud.model.dto.TeacherDto;
import io.fred1895.github.democrud.resources.exceptions.ObjectNotFoundException;
import io.fred1895.github.democrud.model.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void updateTeacher(Long id, TeacherDto newTeacherDto) {
        Teacher teacher = findTeacherById(id);
        updateData(teacher, newTeacherDto);

        repository.save(teacher);
    }

    private void updateData(Teacher teacher, TeacherDto newTeacherDto) {
        if (newTeacherDto.getNome() != null) teacher.setNome(newTeacherDto.getNome());
        if (newTeacherDto.getCpf() != null) teacher.setCpf(newTeacherDto.getCpf());
    }

    public void deleteTeacher(Long id) {
        Teacher teacher = findTeacherById(id);
        repository.delete(teacher);
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
}
