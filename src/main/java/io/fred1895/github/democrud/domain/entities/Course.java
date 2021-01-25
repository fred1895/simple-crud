package io.fred1895.github.democrud.domain.entities;

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
