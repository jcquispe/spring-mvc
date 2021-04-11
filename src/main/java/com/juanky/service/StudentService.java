package com.juanky.service;

import com.juanky.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    final List<Student> students = new ArrayList<>();

    public List<Student> list() {
        if (students.size() == 0) {
            students.add(new Student(1, "Juan", "Perez"));
            students.add(new Student(2, "Carla", "Bernal"));
        }
        return students;
    }

    public void save(Student student) {
        student.setId(students.size() + 1);
        students.add(student);
    }

    public Student get(Integer id) {
        return students.stream().filter(s -> s.getId().equals(id)).findAny();
    }
}
