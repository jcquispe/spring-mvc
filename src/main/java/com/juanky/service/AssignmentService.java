package com.juanky.service;

import com.juanky.model.Assignment;
import com.juanky.model.Grade;
import com.juanky.model.Student;
import com.juanky.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository repo;

    public List<Grade> findByStudent(Integer id) {
        return repo.findByStudent(id);
    }

    public List<Student> findByGrade(String id) {
        return repo.findByGrade(id);
    }

    public void save(Assignment assignment) {
        repo.save(assignment);
    }

    public List<Grade> findByStudentNotInGrade(Integer id) {
        return repo.findByStudentNotInGrade(id);
    }

    public void deleteAssignmentByStudentId(Integer id){
        repo.deleteAssignmentByStudentId(id);
    }

    public void deleteAssignmentByGradeId(String id){
        repo.deleteAssignmentByGradeId(id);
    }
}
