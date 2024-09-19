package ru.itis.springdatajpaexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springdatajpaexample.entity.Pet;
import ru.itis.springdatajpaexample.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    private String name;

    private String surname;

    private Integer age;
    public static UserDto fromEntity(User user){
        return UserDto.builder()
                .age(user.getAge())
                .name(user.getName())
                .id(user.getId()).surname(user.getSurname()).build();
    }
}
