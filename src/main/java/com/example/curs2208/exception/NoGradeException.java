package com.example.curs2208.exception;

public class NoGradeException extends Exception{
    public NoGradeException(){
        super("The grades list is empty");
    }
}
