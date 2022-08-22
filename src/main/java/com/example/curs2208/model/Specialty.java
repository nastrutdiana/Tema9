package com.example.curs2208.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToMany
    @NotNull
    List<Students> students = new ArrayList<>();
    @OneToMany
    @NotNull
    List<Course> courses = new ArrayList<>();
}
