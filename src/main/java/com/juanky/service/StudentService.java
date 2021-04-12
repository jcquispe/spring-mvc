package com.juanky.service;

import com.juanky.model.Student;
import com.juanky.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> list() {
        return repo.findAll();
    }

    public void save(Student student) {
        repo.save(student);
    }

    public Student get(Integer id) {
        return repo.findById(id);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public List<Student> search(String keyword) {
        return repo.findByAny(keyword);
    }
}
