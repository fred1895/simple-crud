package io.fred1895.github.democrud.domains;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Set<Student> students = new HashSet<>();
}
