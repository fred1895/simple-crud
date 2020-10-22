package io.fred1895.github.democrud.resources.exceptions;

public class TeacherNotFoundException extends RuntimeException{
    public TeacherNotFoundException(String msg) {
        super(msg);
    }
}
