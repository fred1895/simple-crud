package io.fred1895.github.democrud.teacher_management.repositories;

import io.fred1895.github.democrud.domain.entities.Course;
import io.fred1895.github.democrud.domain.repositories.CourseRepository;
import io.fred1895.github.democrud.resources.exceptions.ObjectNotFoundException;
import io.fred1895.github.democrud.domain.dto.TeacherDto;
import io.fred1895.github.democrud.domain.entities.Teacher;
import io.fred1895.github.democrud.domain.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.fred1895.github.democrud.teacher_management.utils.TeacherUtil.*;

@Service
public class TeacherRepositoryImpl implements TeacherRepository {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherDAO dao;

    @Override
    public void save(TeacherDto teacherDto) {
        Course course = courseRepository.findById(teacherDto.getIdCurso());
        Teacher teacher = teacherFromDto(teacherDto);
        teacher.setCourse(course);
        dao.save(teacher);
    }

    @Override
    public Teacher findById(Long id) {
        return dao.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("Professor não encontrado") );
    }

    @Override
    public TeacherDto findDtoById(Long id) {
        Teacher teacher = findById(id);
        return teacherToDto(teacher);
    }

    @Override
    public List<TeacherDto> findAll() {
        List<Teacher> teachers = dao.findAll();
        return listTeacherToDto(teachers);
    }

    @Override
    public void update(Long id, TeacherDto newTeacherDto) {
        Teacher teacher = findById(id);
        updateDataTeacher(teacher, newTeacherDto);
        dao.save(teacher);
    }

    @Override
    public void delete(Long id) {
        Teacher teacher = findById(id);
        dao.delete(teacher);
    }
}
