package com.example.curs2208.controller;

import com.example.curs2208.exception.NoGradeException;
import com.example.curs2208.exception.StudentNotFoundeException;
import com.example.curs2208.model.Grade;
import com.example.curs2208.model.Students;
import com.example.curs2208.service.CourseService;
import com.example.curs2208.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentsController {
    private final StudentService studentService;

    @GetMapping("grades/{studentId}")
    public List<Grade> getAllGradesByStudent(@PathVariable Integer studentId) throws StudentNotFoundeException {
        return studentService.getAllGradesByStudent(studentId);
    }

    @PutMapping("grades/add/{studentId}/{grade}")
    public void addGrade(@PathVariable Grade grade, @PathVariable Integer studentId) throws StudentNotFoundeException {
        studentService.addGrade(grade, studentId);
    }

    @GetMapping("greaterthaneight")
    public List<Students> getAllStudentsGradeGreaterThanEight(){
        return studentService.getAllStudentsGradeGreaterThanEight();
    }
    @GetMapping("max")
    public Students max() throws NoGradeException {
        return studentService.maxMean();
    }
    @GetMapping("max/{specialtyId}")
    public Students maxMeanSpecialty(@PathVariable Integer specialtyId) throws NoGradeException {
        return studentService.maxMeanSpecialty(specialtyId);
    }

    @PostMapping
    public Students save(@RequestBody Students students){
        return studentService.save(students);
    }
}
