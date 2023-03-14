package com.ssau.study.repository;

import com.ssau.study.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class JdbcStudentRepository implements StudentRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private RowMapper<Student> studentMapper = (rs, rowNum) -> {
        Student student = new Student();
        student.setId(rs.getLong("id"));
        student.setName(rs.getString("name"));
        student.setBirthdate(rs.getDate("birthdate"));
        student.setNumber(rs.getInt("number"));
        return student;
    };

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from public.students", Integer.class);
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query("select * from public.students", studentMapper);
    }

    @Override
    public List<Student> findAllByName(String name) {
        return namedParameterJdbcTemplate.query("select * from public.students where name ilike '%' || :name || '%'",
                Collections.singletonMap("name", name), studentMapper);
    }

    @Override
    public Student createStudent(Student student) {
        return namedParameterJdbcTemplate.queryForObject(
                "insert into public.students (name, number, birthdate) VALUES (:name, :number, :birthdate) returning id, name, number, birthdate",
                Map.of(
                        "name", student.getName(),
                        "number", student.getNumber(),
                        "birthdate", student.getBirthdate()
                ), studentMapper
        );
    }

    @Override
    public Integer updateStudent(Student student) {
        return namedParameterJdbcTemplate.update(
                "update public.students set name = :name, number = :number, birthdate = :birthdate where id = :id",
                Map.of(
                        "id", student.getId(),
                        "name", student.getName(),
                        "number", student.getNumber(),
                        "birthdate", student.getBirthdate()
                )
        );
    }

    @Override
    public Boolean deleteStudentById(Long id) {
        return namedParameterJdbcTemplate.update("delete from public.students where id = :id",
                Collections.singletonMap("id", id)) != 0;
    }
}
