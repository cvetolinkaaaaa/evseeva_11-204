package ru.itis.demo.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.demo.DTO.FruitDto;
//import ru.itis.demo.DTO.UserDto;
import ru.itis.demo.entity.Fruit;
import ru.itis.demo.entity.Nutrition;
//import ru.itis.demo.entity.Pet;
//import ru.itis.demo.entity.Toy;
//import ru.itis.demo.entity.User;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final EntityManager entityManager;

//    @GetMapping("/create")
//    public String create(){
//        entityManager.getTransaction().begin();
//        User user = User.builder().age(23).name("Azat").surname("Faskhutdinov").build();
//        User user2 = User.builder().age(18).name("Petya").surname("Petrov").build();
//        User user3 = User.builder().age(25).name("Ivan").surname("Ivanov").build();
//        entityManager.persist(user);
//        entityManager.persist(user2);
//        entityManager.persist(user3);
//        entityManager.flush();
//
//        Pet pet = Pet.builder().age(11).name("Bobik").build();
//        Pet pet2 = Pet.builder().age(11).name("Jessy").build();
//        Pet pet3 = Pet.builder().age(11).name("Archy").build();
//
//        entityManager.persist(pet);
//        entityManager.persist(pet2);
//        entityManager.persist(pet3);
//        entityManager.flush();
//
//        Toy toy = Toy.builder().name("Little ball").build();
//        Toy toy2 = Toy.builder().name("Plastic bone").build();
//        Toy toy3 = Toy.builder().name("Squishy toy").build();
//
//        entityManager.persist(toy);
//        entityManager.persist(toy2);
//        entityManager.persist(toy3);
//        entityManager.flush();
//
//
//        pet.setUser(user);
//        pet2.setUser(user);
//        pet3.setUser(user2);
//
//
//        Set<Toy> toys = new HashSet<>();
//        toys.add(toy);
//        toys.add(toy2);
//
//
//
//        pet.setToys(toys);
//        entityManager.getTransaction().commit();
//
//        return "create";
//    }
//
//    @GetMapping("/findById")
//    public UserDto getPets(@RequestParam(name = "id") Long id){
//        entityManager.getTransaction().begin();
//        Query query = entityManager.createQuery("""
//                SELECT user FROM User user
//                JOIN user.pets pet
//                JOIN  pet.toys
//                WHERE  user.id = :id""");
//        query.setParameter("id",id);
//        User user = (User) query.getSingleResult();
//        UserDto userDto = UserDto.fromEntity(user);
//        entityManager.getTransaction().commit();
//        return userDto;
//    }
//    @GetMapping("/change")
//    public String change(@RequestParam(name = "id") Long id, @RequestParam(name = "param") String param, @RequestParam(name = "value") String value){
//        entityManager.getTransaction().begin();
//        String queryString = "UPDATE User user SET user." + param + " = " + value + " WHERE user.id=" + id;
//        Query query = entityManager.createQuery(queryString);
//        query.executeUpdate();
//        entityManager.getTransaction().commit();
//        return ("success");
//    }
@   GetMapping("/cocktail")
    public String fruits(@RequestParam(name = "ingredients") String ingredients, @RequestParam(name = "weight") Integer weight, ModelMap map) {
        List<String> ingridients = Arrays.asList(ingredients.split(","));
        for (int i = 0; i < ingridients.size(); i++) {
            ingridients.set(i, "\'" + ingridients.get(i) + "\'");
        }
        entityManager.getTransaction().begin();


        Double carbohydrates = 0.0;
        Double protein = 0.0;
        Double fat = 0.0;
        Double calories = 0.0;
        Double sugar = 0.0;

        for (int i = 0; i < ingridients.size(); i++) {
            String name = ingridients.get(i);
            String queryString = """
                SELECT fruit FROM Fruit fruit 
                WHERE fruit.name =""" + name;
            Query query = entityManager.createQuery(queryString);
//            query.setParameter("name",ingridients.get(i));
            Fruit fruit = (Fruit) query.getSingleResult();
//            Nutrition nutrition = fruit.getNutrition();
            entityManager.flush();
            FruitDto.NutritionDto nutritionDto = FruitDto.NutritionDto.fromEntity(fruit.getNutrition());
            carbohydrates += nutritionDto.getCarbohydrates()/100 * weight;
            protein += nutritionDto.getProtein()/100 * weight;
            fat += nutritionDto.getFat()/100 * weight;
            calories += nutritionDto.getCalories()/100 * weight;
            sugar += nutritionDto.getSugar()/100 * weight;
        }
        entityManager.getTransaction().commit();

        map.addAttribute("carbohydrates",carbohydrates );
        map.addAttribute("protein", protein);
        map.addAttribute("fat", fat);
        map.addAttribute("calories", calories);
        map.addAttribute("sugar", sugar);
        return "fruits";
    }


}
