package io.fred1895.github.democrud.domain.repositories;

import io.fred1895.github.democrud.domain.dto.TeacherDto;
import io.fred1895.github.democrud.domain.entities.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherRepository {

    void save(TeacherDto teacherDto);

    Teacher findById(Long id);

    TeacherDto findDtoById(Long id);

    List<TeacherDto> findAll();

    void update(Long id, TeacherDto newTeacherDto);

    void delete(Long id);

}
