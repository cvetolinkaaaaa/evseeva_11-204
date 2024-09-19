package ru.itis.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.itis.demo.DTO.FruitDto;
import ru.itis.demo.entity.Fruit;
import ru.itis.demo.entity.Nutrition;
//import ru.itis.demo.entity.User;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static ru.itis.demo.DTO.FruitDto.toEntity;

@Component
@RequiredArgsConstructor
public class MyRunner implements CommandLineRunner {

    private final EntityManager entityManager;
    @Override
    public void run(String... args) throws Exception {
//        entityManager.getTransaction().begin();
//        // Transient
//        User user = new User();
//        user.setName("Azat");
//        user.setSurname("Faskhtudinov");
//        user.setAge(23);
//
//        // Persistent
//        entityManager.persist(user);
//        entityManager.flush();
//        user.setName("new name");
//        entityManager.getTransaction().commit();
//        // Detached
//        user.setName("new name 2");
//
//        // getting objects
//        entityManager.getTransaction().begin();
//        // Persistent
//        User user = entityManager.find(User.class,5L);
//        Query query = entityManager.createQuery("select user FROM User user");
//        List<User> users = query.getResultList();
//        user.setName("New name 3");
//        entityManager.getTransaction().commit();

        ObjectMapper objectMapper = new ObjectMapper();
        String url = "https://www.fruityvice.com/api/fruit/all";
        List<FruitDto> fruits = Arrays.asList(objectMapper.readValue(new URL(url), FruitDto[].class));
        entityManager.getTransaction().begin();
        for (int i = 0; i < fruits.size(); i++) {
            Fruit fruit = toEntity(fruits.get(i));
            entityManager.persist(fruit);
            entityManager.persist(fruit.getNutrition());
        }
        entityManager.getTransaction().commit();
    }
}
