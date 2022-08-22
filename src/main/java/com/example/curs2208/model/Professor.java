package com.example.curs2208.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Professor {
    @Id
    @GeneratedValue
    Integer id;

    @OneToMany
    List<Course> courses = new ArrayList<>();

    @OneToMany
    List<Project> projects = new ArrayList<>();

    String firstName;
    String lastName;
}
