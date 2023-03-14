package com.ssau.study.service;

import com.ssau.study.dto.StudentDTO;
import com.ssau.study.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public List<StudentDTO> findAllStudents() {
        return studentRepo.findAll().stream().map(StudentDTO::fromEntity).toList();
    }

    public Long count() {
        return studentRepo.count();
    }
    public List<StudentDTO> findAllByName(String name) {
        return studentRepo.findAllByName(name).stream().map(StudentDTO::fromEntity).toList();
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        return StudentDTO.fromEntity(studentRepo.save(StudentDTO.toEntity(studentDTO)));
    }

    public StudentDTO updateStudent(StudentDTO studentDTO) {
        return StudentDTO.fromEntity(studentRepo.save(StudentDTO.toEntity(studentDTO)));
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
