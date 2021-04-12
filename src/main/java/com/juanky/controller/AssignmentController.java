package com.juanky.controller;

import com.juanky.model.Assignment;
import com.juanky.model.Grade;
import com.juanky.model.Student;
import com.juanky.service.AssignmentService;
import com.juanky.service.GradeService;
import com.juanky.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AssignmentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private AssignmentService assignmentService;

    @RequestMapping("/assign/student")
    public ModelAndView studentClasses(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("assignment_student");
        Student student = studentService.get(id);
        List<Grade> grades = assignmentService.findByStudent(id);
        mav.addObject("student", student);
        mav.addObject("grades", grades);
        return mav;
    }

    @RequestMapping("/assign/grade")
    public ModelAndView classStudents(@RequestParam String id) {
        ModelAndView mav = new ModelAndView("assignment_grade");
        Grade grade = gradeService.get(id);
        List<Student> students = assignmentService.findByGrade(id);
        mav.addObject("students", students);
        mav.addObject("grade", grade);
        return mav;
    }

    @RequestMapping("/assign/new")
    public String newAssignment(@RequestParam int id,  Map<String, Object> model) {
        Student student = studentService.get(id);
        Assignment assignment = new Assignment();
        List<Grade> grades = assignmentService.findByStudentNotInGrade(id);
        model.put("assignment", assignment);
        model.put("student", student);
        model.put("grades", grades);
        return "assignment_new";
    }

    @RequestMapping(value = "/assign/save", method = RequestMethod.POST)
    public String saveAssignment(@ModelAttribute("assignment") Assignment assignment) {
        assignmentService.save(assignment);
        return "redirect:/assign/student?id="+assignment.getStudentId();
    }

}
