package io.fred1895.github.democrud.teacher_management.utils;

import io.fred1895.github.democrud.teacher_management.dto.TeacherDto;
import io.fred1895.github.democrud.teacher_management.entity.Teacher;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TeacherUtil {
    public static Teacher teacherFromDto(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setNome(teacherDto.getNome());
        teacher.setCpf(teacherDto.getCpf());

        return teacher;
    }

    public static TeacherDto teacherToDto(Teacher teacher) {
        return new TeacherDto(teacher);
    }

    public static List<TeacherDto> listTeacherToDto(List<Teacher> teachers) {
        return teachers.stream().map(TeacherDto::new).collect(toList());
    }

    public static void updateDataTeacher(Teacher teacher, TeacherDto newTeacherDto) {
        if (newTeacherDto.getNome() != null) teacher.setNome(newTeacherDto.getNome());
        if (newTeacherDto.getCpf() != null) teacher.setCpf(newTeacherDto.getCpf());
    }
}
