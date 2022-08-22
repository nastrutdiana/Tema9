package com.example.curs2208.model;

import com.example.curs2208.exception.NoGradeException;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToMany
    List<Grade> grades = new ArrayList<>();
    @NotNull
    @ManyToOne
    Specialty specialty;

    public Integer getAnnualAverageGrade() throws NoGradeException {
        if(grades.isEmpty()){
            throw new NoGradeException();
        }else {
            Integer averageGrade = 0;
            for(Grade grade : grades){
                averageGrade += grade.getValue();
            }
            return averageGrade/grades.size();
        }
    }
}
