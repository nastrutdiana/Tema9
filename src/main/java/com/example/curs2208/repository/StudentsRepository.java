package com.example.curs2208.repository;

import com.example.curs2208.model.Specialty;
import com.example.curs2208.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Integer> {
    List<Students> findAllBySpecialty(Integer specialtyId);
}
