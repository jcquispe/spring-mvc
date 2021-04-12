package com.juanky.service;

import com.juanky.model.Grade;
import com.juanky.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepository repo;

    public List<Grade> list() {
        return repo.findAll();
    }

    public void save(Grade grade) {
        repo.save(grade);
    }

    public Grade get(String id) {
        return repo.findById(id);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }

}
