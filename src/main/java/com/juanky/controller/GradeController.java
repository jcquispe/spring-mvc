package com.juanky.controller;

import com.juanky.model.Grade;
import com.juanky.model.Student;
import com.juanky.service.GradeService;
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
public class GradeController {
    @Autowired
    private GradeService service;

    @RequestMapping("/class")
    public ModelAndView listGrade() {
        List<Grade> listGrade = service.list();
        ModelAndView mav = new ModelAndView("grades");
        mav.addObject("listGrade", listGrade);
        return mav;
    }

    @RequestMapping("/class/new")
    public String newGrade(Map<String, Object> model) {
        Grade grade = new Grade();
        model.put("grade", grade);
        return "grade_new";
    }

    @RequestMapping(value = "/class/save", method = RequestMethod.POST)
    public String saveGrade(@ModelAttribute("grade") Grade grade) {
        service.save(grade);
        return "redirect:/class";
    }

    @RequestMapping("/class/edit")
    public ModelAndView editGrade(@RequestParam String id) {
        ModelAndView mav = new ModelAndView("grade_edit");
        Grade grade = service.get(id);
        mav.addObject("grade", grade);
        return mav;
    }

    @RequestMapping("/class/delete")
    public String deleteGrade(@RequestParam String id) {
        service.delete(id);
        return "redirect:/class";
    }
}
