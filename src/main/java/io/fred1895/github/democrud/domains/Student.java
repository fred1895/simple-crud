package io.fred1895.github.democrud.domains;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String idade;
    private String email;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Course course;
}
