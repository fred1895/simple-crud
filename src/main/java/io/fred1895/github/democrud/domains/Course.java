package io.fred1895.github.democrud.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String disciplina;

    @OneToMany(mappedBy = "course")
    private Set<Teacher> teachers = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Set<Student> students = new HashSet<>();
}
