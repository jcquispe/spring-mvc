package com.juanky.model;

public class Assignment {
    private Integer id;
    private Integer studentId;
    private String gradeCod;

    public Assignment() {
    }

    public Assignment(Integer id, Integer studentId, String gradeCod) {
        this.id = id;
        this.studentId = studentId;
        this.gradeCod = gradeCod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getGradeCod() {
        return gradeCod;
    }

    public void setGradeCod(String gradeCod) {
        this.gradeCod = gradeCod;
    }
}
