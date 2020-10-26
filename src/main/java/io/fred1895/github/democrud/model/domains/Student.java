package io.fred1895.github.democrud.model.domains;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String idade;
    private String email;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
