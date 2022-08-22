package com.example.curs2208.exception;

public class StudentNotFoundeException extends Exception{
    public StudentNotFoundeException(){
        super("The student that you are looking for is not exist!");
    }
}
