package com.ssau.study.repository;

import com.ssau.study.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findAllByName(String name);
}
