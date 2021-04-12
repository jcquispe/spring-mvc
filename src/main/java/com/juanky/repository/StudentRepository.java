package com.juanky.repository;

import com.juanky.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentRepository {

    final List<Student> students = new ArrayList<>();

    public List<Student> findAll() {
        if (students.size() == 0) {
            students.add(new Student(1, "Juan", "Perez"));
            students.add(new Student(2, "Carla", "Bernal"));
            students.add(new Student(3, "Gabriel", "Fernandez"));
            students.add(new Student(4, "Marcelino", "Calle"));
            students.add(new Student(5, "Mauricio", "Soto"));
        }
        return students;
    }

    public void save(Student student) {
        if (student.getId() != null) {
            students.forEach(st -> {
                if (st.getId() == student.getId()) {
                    st.setFirstName(student.getFirstName());
                    st.setLastName(student.getLastName());
                }
            });
        }
        else {
            student.setId(students.get(students.size() - 1).getId() + 1);
            students.add(student);
        }
    }

    public Student findById(Integer id) {
        Optional<Student> student = students.stream().filter(s -> s.getId().equals(id)).findAny();
        try {
            return student.get();
        } catch (Exception e) {
            e.printStackTrace();
            return new Student();
        }
    }

    public void deleteById(Integer id) {
        students.removeIf(s -> s.getId() == id);
    }

    public List<Student> findByAny(String keyword) {
        List<Student> searchList = students;
        List<Student> result = new ArrayList<>();
        searchList.forEach(st -> {
            if (String.valueOf(st.getId()).contains(keyword) || st.getFirstName().contains(keyword) || st.getLastName().contains(keyword)) {
                result.add(st);
            }
        });
        return result;
    }
}
