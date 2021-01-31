package io.fred1895.github.democrud.infra;

import io.fred1895.github.democrud.domain.entities.Course;
import io.fred1895.github.democrud.domain.dto.CourseDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ConverterUtil {

    public static Course courseFromDto(CourseDto courseDto) {
        Course course = new Course();
        course.setDisciplina(courseDto.getDisciplina());
        course.setDescricao(courseDto.getDescricao());
        return course;
    }

    public static CourseDto courseToDto(Course course) {
        return new CourseDto(course);
    }

    public static void updateCourseData(Course course, CourseDto newCourseDto) {
        if (newCourseDto.getDisciplina() != null) course.setDisciplina(newCourseDto.getDisciplina());
        if (newCourseDto.getDescricao() != null) course.setDescricao(newCourseDto.getDescricao());
    }

    public static List<CourseDto> listCourseToDto(List<Course> courses) {
        return courses.stream().map(CourseDto::new).collect(toList());
    }
}
