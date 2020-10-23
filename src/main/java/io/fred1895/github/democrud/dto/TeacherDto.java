package io.fred1895.github.democrud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.fred1895.github.democrud.domains.Teacher;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class TeacherDto implements Serializable {
    private Long id;
    private String nome;
    private String cpf;

    @JsonProperty("id_curso")
    private Long idCurso;

    public TeacherDto(Teacher teacher) {
        this.id = teacher.getId();
        this.nome = teacher.getNome();
        this.cpf = teacher.getCpf();
        this.idCurso = teacher.getId();
    }
}
