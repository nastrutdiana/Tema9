package com.example.curs2208.controller;

import com.example.curs2208.exception.NoGradeException;
import com.example.curs2208.exception.SpecialtyNotFoundException;
import com.example.curs2208.model.Specialty;
import com.example.curs2208.model.Students;
import com.example.curs2208.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("specialty")
public class SpecialtyController {
    private final SpecialtyService specialtyService;

    @GetMapping("{specialtyId}")
    public List<Students> getAllStudentBySpecialty(@PathVariable Integer specialtyId) throws SpecialtyNotFoundException {
        return specialtyService.getAllStudentsBySpecialty(specialtyId);
    }

    @GetMapping("max")
    public Specialty getSpecialtyWithMaxStudents(){
        return specialtyService.getSpecialtyWithMaxStudents();
    }

    @GetMapping("mean/{specialtyId}")
    public Integer mean(@PathVariable Integer specialtyId) throws NoGradeException {
        return specialtyService.mean(specialtyId);
    }
    @PostMapping
    public void save(@RequestBody Specialty specialty){
        specialtyService.save(specialty);
    }
}
