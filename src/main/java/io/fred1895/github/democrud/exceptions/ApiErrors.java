package io.fred1895.github.democrud.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrors {

    private Integer statusCode;
    private Long timeStamp;
    private List<String> errors;

}
