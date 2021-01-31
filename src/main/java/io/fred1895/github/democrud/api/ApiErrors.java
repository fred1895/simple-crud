package io.fred1895.github.democrud.api;

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
