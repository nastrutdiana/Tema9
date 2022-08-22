package com.example.curs2208.service;

import com.example.curs2208.exception.NoGradeException;
import com.example.curs2208.exception.StudentNotFoundeException;
import com.example.curs2208.model.Grade;
import com.example.curs2208.model.Specialty;
import com.example.curs2208.model.Students;
import com.example.curs2208.repository.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentsRepository studentsRepository;

    public void addGrade(Grade grade, Integer studentId) throws StudentNotFoundeException {
        Optional<Students> tmpOptionalStudent = studentsRepository.findById(studentId);
        if(!tmpOptionalStudent.isPresent()){
            throw new StudentNotFoundeException();
        }else {
            tmpOptionalStudent.get().getGrades().add(grade);
            studentsRepository.save(tmpOptionalStudent.get());
        }
    }

    public List<Grade> getAllGradesByStudent(Integer userId) throws StudentNotFoundeException {
        Optional<Students> tmpOptionalStudent = studentsRepository.findById(userId);
        if(!tmpOptionalStudent.isPresent()){
            throw new StudentNotFoundeException();
        }else {
            Students tmpStudent = tmpOptionalStudent.get();
            return tmpStudent.getGrades();
        }
    }

    public List<Students> getAllStudentsGradeGreaterThanEight(){
        return studentsRepository.findAll().stream().filter(students -> {
            try {
                return students.getAnnualAverageGrade() > 8;
            } catch (NoGradeException e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList());
    }

    public Students maxMean() throws NoGradeException {
        List<Students> students = studentsRepository.findAll();
        Students student = students.get(0);
        Integer max = student.getAnnualAverageGrade();
        for(int i = 1; i < students.size(); i++){
            if(students.get(i).getAnnualAverageGrade() > max){
                student = students.get(i);
                max = student.getAnnualAverageGrade();
            }
        }
        return student;
    }

    public Students maxMeanSpecialty(Integer specialtyId) throws NoGradeException {
        List<Students> students = studentsRepository.findAllBySpecialty(specialtyId);
        Students student = students.get(0);
        Integer max = student.getAnnualAverageGrade();
        for(int i = 1; i < students.size(); i++){
            if(students.get(i).getAnnualAverageGrade() > max){
                student = students.get(i);
                max = student.getAnnualAverageGrade();
            }
        }
        return student;
    }

    public Students save(Students students){
        return studentsRepository.save(students);
    }
}
