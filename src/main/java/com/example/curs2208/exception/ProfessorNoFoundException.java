package com.example.curs2208.exception;

public class ProfessorNoFoundException extends Exception{
    public ProfessorNoFoundException(){
        super("Professor not found");
    }
}
