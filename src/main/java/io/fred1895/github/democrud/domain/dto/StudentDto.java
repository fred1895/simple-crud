package io.fred1895.github.democrud.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.fred1895.github.democrud.domain.entities.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class StudentDto implements Serializable {

    private Long id;
    private String nome;
    private String idade;
    private String email;

    @JsonProperty("id_curso")
    private Long idCurso;

    public StudentDto(Student student) {
        this.id = student.getId();
        this.nome = student.getNome();
        this.idade = student.getIdade();
        this.idCurso = student.getCourse().getId();
    }
}
