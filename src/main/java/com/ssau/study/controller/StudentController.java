package com.ssau.study.controller;

import com.ssau.study.dto.StudentDTO;
import com.ssau.study.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/count")
    public long count() {
        return studentService.count();
    }

    @GetMapping
    public List<StudentDTO> findAll() {
        return studentService.findAllStudents();
    }

    @GetMapping("/{name}")
    public List<StudentDTO> findAllByName(@PathVariable String name) {
        return studentService.findAllByName(name);
    }

    @PostMapping("/create")
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @PutMapping("/update")
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(studentDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }
}
