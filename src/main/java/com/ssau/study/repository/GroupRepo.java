package com.ssau.study.repository;

import com.ssau.study.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface GroupRepo extends JpaRepository<Group, Long> {
    List<Group> findAllByName(String name);
    Optional<Group> findById(Long id);
}
