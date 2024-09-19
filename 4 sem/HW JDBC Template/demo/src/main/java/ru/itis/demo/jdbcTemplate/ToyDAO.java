package ru.itis.demo.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ToyDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ToyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void querySecond() {
        String query = """
                SELECT t.name 
                FROM toy t 
                JOIN pet_toy pt ON pt.toy_id = t.id 
                GROUP BY t.id, t.name 
                HAVING COUNT(pt.pet_id) >= 2
                """;

        List<String> toyNames = jdbcTemplate.query(query, (rs, rowNum) -> rs.getString("name"));
        toyNames.forEach(System.out::println);
    }
}
