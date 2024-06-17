package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class main {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/Addstudent")
    public String addStudent() {
        return "form";
    }

    @PostMapping("/Add")
    public String addStudent(
            @RequestParam("rollno") int rollno,
            @RequestParam("age") int age,
            @RequestParam("name") String name,
            Model model) {
        studentService.addStudent(new Student(rollno, age, name));
        model.addAttribute("message", "Data saved");
        return "form";
    }

    @GetMapping("/Updatestudent")
    public String updateStudent() {
        return "form1";
    }

    @PostMapping("/Update")
    public String updateStudent(
            @RequestParam("rollno") int rollno,
            @RequestParam("age") int age,
            @RequestParam("name") String name,
            Model model) {
        studentService.updateStudent(rollno, new Student(rollno, age, name));
        model.addAttribute("message", "Data updated");
        return "form1";
    }

    @GetMapping("/Deletestudent")
    public String deleteStudent() {
        return "form2";
    }

    @PostMapping("/Delete")
    public String deleteStudent(
            @RequestParam("rollno") int rollno,
            Model model) {
        studentService.deleteStudent(rollno);
        model.addAttribute("message", "Data deleted");
        return "form2";
    }

    @GetMapping("/Showstudents")
    public String displayStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "show";
    }
}
