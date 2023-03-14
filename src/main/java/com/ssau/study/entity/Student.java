package com.ssau.study.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="students", schema = "public")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private Date birthdate;
    @Column
    private int number;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Group group;
}
