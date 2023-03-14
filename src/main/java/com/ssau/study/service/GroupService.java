package com.ssau.study.service;

import com.ssau.study.dto.GroupDTO;
import com.ssau.study.dto.StudentDTO;
import com.ssau.study.entity.Student;
import com.ssau.study.repository.GroupRepo;
import com.ssau.study.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private StudentRepo studentRepo;

    public List<GroupDTO> findAllGroups() {
        return groupRepo.findAll().stream().map(GroupDTO::fromEntity).toList();
    }

    public Long count() {
        return groupRepo.count();
    }
    public List<GroupDTO> findAllByName(String name) {
        return groupRepo.findAllByName(name).stream().map(GroupDTO::fromEntity).toList();
    }
    public Optional<GroupDTO> findById(Long id) {
        return groupRepo.findById(id).map(GroupDTO::fromEntity);
    }

    public GroupDTO createGroup(GroupDTO groupDTO) {
        return GroupDTO.fromEntity(groupRepo.save(GroupDTO.toEntity(groupDTO)));
    }

    public StudentDTO createStudent(long groupId, StudentDTO studentDTO) {
        Student student = StudentDTO.toEntity(studentDTO);
        student.setGroup(groupRepo.findById(groupId).orElseThrow());
        return StudentDTO.fromEntity(studentRepo.save(student));
    }

    public GroupDTO updateGroup(GroupDTO groupDTO) {
        return GroupDTO.fromEntity(groupRepo.save(GroupDTO.toEntity(groupDTO)));
    }

    public void deleteGroup(Long id) {
        groupRepo.deleteById(id);
    }
}
