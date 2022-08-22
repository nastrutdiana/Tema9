package com.example.curs2208.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue
    Integer id;

    String project;

    @ManyToOne
    Professor professor;
}
