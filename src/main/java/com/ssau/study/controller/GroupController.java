package com.ssau.study.controller;

import com.ssau.study.dto.GroupDTO;
import com.ssau.study.dto.StudentDTO;
import com.ssau.study.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/count")
    public long count() {
        return groupService.count();
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping
    public List<GroupDTO> findAll() {
        return groupService.findAllGroups();
    }

    @GetMapping("/{name}")
    public List<GroupDTO> findAllByName(@PathVariable String name) {
        return groupService.findAllByName(name);
    }

    /*@GetMapping("/{id}")
    public Optional<GroupDTO> findById(@PathVariable Long id) {
        return groupService.findById(id);
    }*/

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public GroupDTO createGroup(@RequestBody GroupDTO groupDTO) {
        return groupService.createGroup(groupDTO);
    }

    @PostMapping("/{groupId}/students")
    public StudentDTO createStudent(@PathVariable Long groupId, @RequestBody StudentDTO studentDTO) {
        return groupService.createStudent(groupId, studentDTO);
    }

    @PutMapping("/update")
    public GroupDTO updateGroup(@RequestBody GroupDTO groupDTO) {
        return groupService.updateGroup(groupDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGroup(@PathVariable("id") Long id) {
        groupService.deleteGroup(id);
    }
}
