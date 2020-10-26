package io.fred1895.github.democrud.resources;

import io.fred1895.github.democrud.resources.exceptions.ApiErrors;
import io.fred1895.github.democrud.resources.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiErrors> handleResponseStatusException(ResponseStatusException e) {
        Integer httpStatusCode = e.getStatus().value();
        String msg = e.getReason();
        ApiErrors apiErrors = new ApiErrors(httpStatusCode, System.currentTimeMillis(), Arrays.asList(msg));
        return ResponseEntity.status(httpStatusCode).body(apiErrors);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ApiErrors> handleTeacherNotFoundException(ObjectNotFoundException e) {
        String msg = e.getMessage();
        ApiErrors apiErrors = new ApiErrors(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), Arrays.asList(msg));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiErrors);
    }

}
