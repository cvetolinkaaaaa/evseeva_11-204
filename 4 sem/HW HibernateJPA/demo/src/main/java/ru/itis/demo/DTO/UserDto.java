//package ru.itis.demo.DTO;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import ru.itis.demo.entity.User;
//
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class UserDto {
//
//    private Long id;
//
//    private String name;
//    private String surname;
//
//    private Integer age;
//    private List<PetDto> pets;
//
//    public static UserDto fromEntity(User user){
//        return UserDto.builder()
//                .age(user.getAge())
//                .surname(user.getSurname())
//                .name(user.getName())
//                .id(user.getId()).pets(user.getPets().stream().map(pet -> PetDto.fromEntity(pet)).toList()).build();
//    }
//}