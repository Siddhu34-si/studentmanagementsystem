package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> studentList = new ArrayList<>();

    public List<Student> getAllStudents() {
        return studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void updateStudent(int rollno, Student updatedStudent) {
        for (Student student : studentList) {
            if (student.getRollno() == rollno) {
                student.setAge(updatedStudent.getAge());
                student.setName(updatedStudent.getName());
                break;
            }
        }
    }

    public void deleteStudent(int rollno) {
        studentList.removeIf(student -> student.getRollno() == rollno);
    }
}

