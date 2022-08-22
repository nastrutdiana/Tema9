package com.example.curs2208.service;

import com.example.curs2208.exception.NoGradeException;
import com.example.curs2208.exception.SpecialtyNotFoundException;
import com.example.curs2208.model.Specialty;
import com.example.curs2208.model.Students;
import com.example.curs2208.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public List<Students> getAllStudentsBySpecialty(Integer specialtyId) throws SpecialtyNotFoundException {
        Optional<Specialty> optionalSpecialty = specialtyRepository.findById(specialtyId);
        if(!optionalSpecialty.isPresent()){
            throw new SpecialtyNotFoundException();
        } else{
            return optionalSpecialty.get().getStudents();
        }
    }

    public Specialty getSpecialtyWithMaxStudents(){
        List<Specialty> specialties= specialtyRepository.findAll();
        Integer max = specialties.get(0).getStudents().size();
        Specialty specialty = specialties.get(0);
        for(int i = 1; i < specialties.size(); i++){
            if(specialties.get(i).getStudents().size() > max) {
                max = specialties.get(i).getStudents().size();
                specialty = specialties.get(i);
            }
        }
        return specialty;
    }

    public Integer mean(Integer specialtyId) throws NoGradeException {
        List<Students> students = specialtyRepository.findById(specialtyId).get().getStudents();
        Integer mean = 0;
        for (Students student : students){
            mean += student.getAnnualAverageGrade();
        }
        return mean / students.size();
    }

    public void save(Specialty specialty){
        specialtyRepository.save(specialty);
    }

}
