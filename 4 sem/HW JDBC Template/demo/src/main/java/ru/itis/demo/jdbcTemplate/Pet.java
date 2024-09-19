package ru.itis.demo.jdbcTemplate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pet {
    private Long id;

    private String name;

    private Integer age;
    private List<Toy> toys;
}
