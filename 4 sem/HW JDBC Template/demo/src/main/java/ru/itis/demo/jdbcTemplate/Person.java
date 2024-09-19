package ru.itis.demo.jdbcTemplate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private Integer id;

    private String name;

    private int age;

    private String email;
    private List<Pet> pets;
}