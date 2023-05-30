package org.example.exceptions;

public class NullElementException extends RuntimeException{
    public NullElementException(){
        super();
    }

    public NullElementException(String message){
        super(message);
    }
}
