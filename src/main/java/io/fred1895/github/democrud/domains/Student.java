package io.fred1895.github.democrud.domains;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {
    private Long id;
    private String nome;
    private String idade;
    private String cpf;
    private String telefone;
    private Integer sala;

    @ManyToMany(mappedBy = "students")
    private List<Teacher> teachers = new ArrayList<>();
}
