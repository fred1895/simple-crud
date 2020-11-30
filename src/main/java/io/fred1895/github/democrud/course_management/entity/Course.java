package io.fred1895.github.democrud.course_management.entity;

import io.fred1895.github.democrud.student_management.entity.Student;
import io.fred1895.github.democrud.teacher_management.entity.Teacher;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String disciplina;
    private String descricao;

    @OneToMany(mappedBy = "course")
    private List<Teacher> teachers = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Student> students = new ArrayList<>();
}
