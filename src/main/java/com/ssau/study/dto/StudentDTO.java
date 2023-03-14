package com.ssau.study.dto;

import com.ssau.study.entity.Student;
import lombok.Data;

import java.util.Date;

@Data
public class StudentDTO {
    private long id;
    private String name;
    private Date birthdate;
    private int number;

    public static StudentDTO fromEntity(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setBirthdate(student.getBirthdate());
        studentDTO.setNumber(student.getNumber());
        return studentDTO;
    }

    public static Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setBirthdate(studentDTO.getBirthdate());
        student.setNumber(studentDTO.getNumber());
        return student;
    }
}

