package io.fred1895.github.democrud.course_management.dto;

import io.fred1895.github.democrud.course_management.entity.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CourseDto implements Serializable {

    private Long id;
    private String disciplina;
    private String descricao;

    public CourseDto(Course course) {
        this.id = course.getId();
        this.descricao = course.getDescricao();
        this.disciplina = course.getDisciplina();
    }

}
