package com.juanky.repository;

import com.juanky.model.Grade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradeRepository {
    final List<Grade> grades = new ArrayList<>();

    public List<Grade> findAll() {
        if (grades.size() == 0) {
            grades.add(new Grade("FIS100", "FISICA I", "Física básica"));
            grades.add(new Grade("ALG100", "ALGEBRA I", "Algebrá lineal"));
            grades.add(new Grade("MAT101", "CALCULO I", "Límites, continuidad, susesiones y series"));
            grades.add(new Grade("MAT102", "CALCULO II", "Cáculo diferencia e integral"));
        }
        return grades;
    }

    public void save(Grade grade) {
        final boolean[] saved = {false};
        grades.forEach(cl -> {
            if (cl.getCod().equals(grade.getCod())) {
                cl.setTitle(grade.getTitle());
                cl.setDescription(grade.getDescription());
                saved[0] = true;
            }
        });
        if (!saved[0])
            grades.add(grade);
    }

    public Grade findById(String id) {
        Optional<Grade> grade = grades.stream().filter(cl -> cl.getCod().equals(id)).findAny();
        try {
            return grade.get();
        } catch (Exception e) {
            e.printStackTrace();
            return new Grade();
        }
    }

    public void deleteById(String id) {
        grades.removeIf(cl -> cl.getCod().equals(id));
    }
}
