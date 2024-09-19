package ru.itis.demo.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(name, age, email) VALUES(?, ?, ?)", person.getName(), person.getAge(),
                person.getEmail());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?", updatedPerson.getName(),
                updatedPerson.getAge(), updatedPerson.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

//    public void find(int id){
//        return jdbcTemplate.query("SELECT * FROM Person LEFT JOIN Pet on Person.id = Pet.user_id WHERE Person.id=?", )
//    }
    public void findAll() {
        jdbcTemplate.query("""
                SELECT p.id, p.name FROM person p 
                JOIN pet pet ON p.id = pet.person_id 
                JOIN pet_toy pt ON pt.pet_id = pet.id 
                JOIN toy t ON t.id = pt.toy_id 
                WHERE pet.name LIKE '%t%' AND t.name LIKE '%plastic%'
                GROUP BY p.id, p.name 
                HAVING COUNT(t.id) >= 2
                """, new PersonResultExtractor());
    }

}