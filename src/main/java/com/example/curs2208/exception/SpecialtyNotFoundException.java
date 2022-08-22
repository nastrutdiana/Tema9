package com.example.curs2208.exception;

public class SpecialtyNotFoundException extends Exception{
    public SpecialtyNotFoundException(){
        super("The specialty was not found");
    }
}
