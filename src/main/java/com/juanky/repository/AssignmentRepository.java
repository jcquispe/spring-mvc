package com.juanky.repository;

import com.juanky.model.Assignment;
import com.juanky.model.Grade;
import com.juanky.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentRepository {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private StudentRepository studentRepository;

    final List<Assignment> assignments = new ArrayList<>();

    public List<Assignment> findAll() {
        if (assignments.size() == 0) {
            assignments.add(new Assignment(1, 1, "MAT101"));
            assignments.add(new Assignment(2, 1, "MAT102"));
            assignments.add(new Assignment(3, 2, "MAT100"));
            assignments.add(new Assignment(5, 2, "MAT101"));
            assignments.add(new Assignment(5, 3, "MAT100"));
        }
        return assignments;
    }

    public List<Assignment> studentAssignments(Integer id) {
        List<Assignment> studentAssignment = new ArrayList<>();
        gradeRepository.findAll();
        assignments.forEach(a -> {
            if (a.getStudentId() == id) {
                studentAssignment.add(a);
            }
        });
        return studentAssignment;
    }

    public List<Grade> findByStudent(Integer id) {
        findAll();
        List<Grade> studentGrade = new ArrayList<>();
        gradeRepository.findAll();
        assignments.forEach(a -> {
            if (a.getStudentId() == id) {
                studentGrade.add(gradeRepository.findById(a.getGradeCod()));
            }
        });
        return studentGrade;
    }

    public List<Grade> findByStudentNotInGrade(Integer id) {
        findAll();
        List<Grade> grades = gradeRepository.findAll();
        List<Assignment> studentAssignments = studentAssignments(id);
        List<Grade> gradeNotIn = grades.stream()
                .filter(f -> !studentAssignments.stream()
                        .anyMatch(s -> f.getCod().equals(s.getGradeCod())))
                .collect(Collectors.toList());
        return gradeNotIn;
    }

    public void save(Assignment assignment) {
        if (assignment.getId() != null) {
        }
        else {
            assignment.setId(assignments.get(assignments.size() - 1).getId() + 1);
            assignments.add(assignment);
        }
    }

    public List<Student> findByGrade(String id) {
        findAll();
        List<Student> studentGrade = new ArrayList<>();
        studentRepository.findAll();
        assignments.forEach(a -> {
            if (a.getGradeCod().equals(id)) {
                studentGrade.add(studentRepository.findById(a.getStudentId()));
            }
        });
        return studentGrade;
    }

    public void deleteAssignmentByStudentId(Integer id) {
        findAll();
        assignments.removeIf(a -> a.getStudentId() == id);
    }

    public void deleteAssignmentByGradeId(String id) {
        findAll();
        assignments.removeIf(a -> a.getGradeCod().equals(id));
    }

}
