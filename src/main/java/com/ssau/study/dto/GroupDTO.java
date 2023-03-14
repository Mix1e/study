package com.ssau.study.dto;

import com.ssau.study.entity.Group;
import com.ssau.study.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class GroupDTO {
    private long id;
    private String name;
    private List<StudentDTO> students;

    public static GroupDTO fromEntity(Group group) {
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setId(group.getId());
        groupDTO.setName(group.getName());
        if(group.getStudents() != null && !group.getStudents().isEmpty()) {
            List<Student> studentList = group.getStudents();
            groupDTO.setStudents(
                    studentList.stream().map(StudentDTO::fromEntity).toList()
            );
        }
        return groupDTO;
    }

    public static Group toEntity(GroupDTO groupDTO) {
        Group group = new Group();
        group.setId(groupDTO.getId());
        group.setName(groupDTO.getName());
        return group;
    }
}
