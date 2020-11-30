package io.fred1895.github.democrud.teacher_management.entity;

import io.fred1895.github.democrud.course_management.entity.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}