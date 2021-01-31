package io.fred1895.github.democrud.api;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
