package com.example.curs2208.service;

import com.example.curs2208.exception.ProfessorNoFoundException;
import com.example.curs2208.model.Course;
import com.example.curs2208.model.Professor;
import com.example.curs2208.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public List<Course> getAllCoursesByProfessor(Integer professorId) throws ProfessorNoFoundException {
        Optional<Professor> optionalProfessor = professorRepository.findById(professorId);
        if(!optionalProfessor.isPresent()){
            throw new ProfessorNoFoundException();
        }else {
            return optionalProfessor.get().getCourses();
        }
    }
}
