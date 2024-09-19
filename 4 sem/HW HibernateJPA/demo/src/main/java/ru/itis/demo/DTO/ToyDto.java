//package ru.itis.demo.DTO;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import ru.itis.demo.entity.Toy;
//import ru.itis.demo.entity.User;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class ToyDto {
//    private Long id;
//
//    private String name;
//    public static ToyDto fromEntity(Toy toy){
//        return ToyDto.builder()
//                .name(toy.getName())
//                .id(toy.getId()).build();
//    }
//}
