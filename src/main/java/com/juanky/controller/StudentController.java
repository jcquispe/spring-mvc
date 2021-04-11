package com.juanky.controller;

import com.juanky.model.Student;
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
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping("/student")
    public ModelAndView list() {
        List<Student> listStudent = service.list();
        ModelAndView mav = new ModelAndView("students");
        mav.addObject("listStudent", listStudent);
        return mav;
    }

    @RequestMapping("/student/new")
    public String newForm(Map<String, Object> model) {
        Student student = new Student();
        model.put("student", student);
        return "student_new";
    }

    @RequestMapping(value = "/student/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("student") Student student) {
        service.save(student);
        return "redirect:/student";
    }

    @RequestMapping("/student/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_student");
        Student student = service.get(id);
        mav.addObject("student", student);
        return mav;
    }
}
