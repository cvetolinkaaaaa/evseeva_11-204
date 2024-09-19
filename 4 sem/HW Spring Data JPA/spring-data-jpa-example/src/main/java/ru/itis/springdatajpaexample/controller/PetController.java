package ru.itis.springdatajpaexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.springdatajpaexample.dto.PetDto;
import ru.itis.springdatajpaexample.dto.UserDto;
import ru.itis.springdatajpaexample.entity.Toy;
import ru.itis.springdatajpaexample.entity.User;
import ru.itis.springdatajpaexample.repository.PetRepository;
import ru.itis.springdatajpaexample.repository.ToyRepository;
import ru.itis.springdatajpaexample.repository.UserRepository;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ToyRepository toyRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/pets/findByToy")
    public List<PetDto> getPets(@RequestParam(name = "toy_id") Long toyId){
        Toy toy = toyRepository.findById(toyId).get();
        return petRepository.findAllByToysContains(toy).stream()
                .map(PetDto::fromEntity).toList();
    }

    @GetMapping("/user/find")
    public List<UserDto> getUser(@RequestParam("toyName") String toyName, @RequestParam("petName") String petName){
        return userRepository.findAllByNameAndToy(toyName, petName)
                .stream()
                .map(UserDto::fromEntity)
                .toList();
    }

    @GetMapping("/pets/findByAgeRangeAndName")
    public List<PetDto> getPetsByAgeRangeAndName(@RequestParam("start") int start, @RequestParam("end") int end , @RequestParam("name") String name ) {
        return petRepository.findByAgeBetweenAndName(start, end, name)
                .stream()
                .map(PetDto::fromEntity)
                .toList();
    }

    @GetMapping("/users/findByPetNameAndToyCount")
    public List<UserDto> getUsersByPetNameAndToyCount(@RequestParam("petName") String petName, @RequestParam("toyCount") int toyCount){
        return userRepository.findByPetNameAndToyCount(petName, toyCount)
                .stream()
                .map(UserDto::fromEntity)
                .toList();
    }

    @GetMapping("users/findByPetNameAndPetAgeGraterThan")
    public List<UserDto> getUsersByPetNameAndPetAgeGraterThan(@RequestParam("petName") String petName, @RequestParam("ageGreater") int ageGreater){
        return userRepository.findByPetNameAndPetAgeGreaterThan(petName, ageGreater)
                .stream()
                .map(UserDto::fromEntity)
                .toList();
    }

}

//INSERT INTO my_users (name, surname, age) VALUES ('John', 'Doe', 30);
//INSERT INTO my_users (name, surname, age) VALUES ('Alice', 'Smith', 25);
//
//INSERT INTO pet (name, age, user_id) VALUES ('Bobik', 5, 1);
//INSERT INTO pet (name, age, user_id) VALUES ('Buddy', 2, 2);
//
//INSERT INTO toy (name) VALUES ('Ball');
//INSERT INTO toy (name) VALUES ('Plastic bone');
//
//INSERT INTO pet_toys (pet_id, toy_id) VALUES (1, 2);
//INSERT INTO pet_toys (pet_id, toy_id) VALUES (2, 2);
