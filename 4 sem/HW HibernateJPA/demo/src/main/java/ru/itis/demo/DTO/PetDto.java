//package ru.itis.demo.DTO;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import ru.itis.demo.entity.Pet;
//import ru.itis.demo.entity.Toy;
//import ru.itis.demo.entity.User;
//
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class PetDto {
//    private Long id;
//
//    private String name;
//
//    private Integer age;
//    private List<ToyDto> toys;
//
//    public static PetDto fromEntity(Pet pet){
//        return PetDto.builder()
//                .age(pet.getAge())
//                .name(pet.getName())
//                .toys(pet.getToys().stream().map(toy -> ToyDto.fromEntity(toy)).toList())
//                .id(pet.getId()).build();
//    }
//
//}
