package ru.itis.demo.jdbcTemplate;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonResultExtractor implements ResultSetExtractor<List<Person>> {
    @Override
    public List<Person> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Integer, Person> personMap = new HashMap<>();
        while (rs.next()) {
            int personId = rs.getInt("id");
            Person person = personMap.get(personId);
            if (person == null) {
                person = new Person();
                person.setId(personId);
                person.setName(rs.getString("name"));
                person.setAge(rs.getInt("age"));
                person.setEmail(rs.getString("email"));
                person.setPets(new ArrayList<>());
                personMap.put(personId, person);
            }

            Pet pet = new Pet();
            pet.setId(rs.getLong("pet_id"));
            pet.setName(rs.getString("pet_name"));
            pet.setToys(new ArrayList<>());

            person.getPets().add(pet);
        }
        return new ArrayList<>(personMap.values());
    }
}

