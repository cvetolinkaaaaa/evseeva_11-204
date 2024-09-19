package ru.itis.springdatajpaexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.springdatajpaexample.entity.Pet;
import ru.itis.springdatajpaexample.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT user FROM User user " +
            "JOIN user.pets pet " +
            "JOIN pet.toys t " +
            "WHERE pet.name = :petName AND t.name = :toyName")
    List<User> findAllByNameAndToy(@Param("toyName") String toyName, @Param("petName") String petName);

    @Query("SELECT u FROM User u JOIN u.pets p WHERE p.name = :petName AND size(p.toys) = :toyCount")
    List<User> findByPetNameAndToyCount(@Param("name") String petName, @Param("toyCount") int toyCount);

    @Query("SELECT u FROM User u JOIN u.pets p WHERE p.name = :petName AND p.age > :ageGreater")
    List<User> findByPetNameAndPetAgeGreaterThan(@Param("name") String petName, @Param("ageGreater") int ageGreater);
    @Query("SELECT u FROM User u JOIN FETCH")
    List<User> findAll();

}
