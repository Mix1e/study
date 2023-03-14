package com.ssau.study.repository;

import com.ssau.study.entity.Student;

import java.util.List;

public interface StudentRepository {
    int count();

    List<Student> findAll();

    List<Student> findAllByName(String name);

    Student createStudent(Student student);

    Integer updateStudent(Student student);

    Boolean deleteStudentById(Long id);
}
