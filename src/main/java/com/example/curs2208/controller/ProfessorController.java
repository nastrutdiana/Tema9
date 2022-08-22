package com.example.curs2208.controller;

import com.example.curs2208.exception.ProfessorNoFoundException;
import com.example.curs2208.model.Course;
import com.example.curs2208.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("professor")
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping("{professorId}")
    public List<Course> getAllCourseByProfessor(@PathVariable Integer professorId) throws ProfessorNoFoundException {
        return professorService.getAllCoursesByProfessor(professorId);
    }
}
