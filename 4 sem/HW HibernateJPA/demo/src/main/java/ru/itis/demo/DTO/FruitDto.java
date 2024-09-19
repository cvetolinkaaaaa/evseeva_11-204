package ru.itis.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import ru.itis.demo.entity.Fruit;
import ru.itis.demo.entity.Nutrition;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class FruitDto {
    private Long id;

    private String name;

    private NutritionDto nutritions;

//    public static NutritionDto fromEntity(Fruit fruit) {
//        return FruitDto.builder()
//                .id(fruit.getId())
//                .name(fruit.getName())
//                .nutritionDto(fromEntity(fruit.getNutrition()))
//                .build();
//    }
    public static Fruit toEntity(FruitDto fruitDto) {
        return Fruit.builder()
                .name(fruitDto.getName())
                .nutrition(fruitDto.getNutritions().toEntity(fruitDto.getNutritions()))
                .build();
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class NutritionDto {
        private Long id;
        Double carbohydrates;

        Double protein;

        Double fat;

        Double calories;

        Double sugar;

        public static NutritionDto fromEntity(Nutrition nutrition) {
            return NutritionDto.builder()
                    .id(nutrition.getId())
                    .carbohydrates(nutrition.getCarbohydrates())
                    .protein(nutrition.getProtein())
                    .fat(nutrition.getFat())
                    .calories(nutrition.getCalories())
                    .sugar(nutrition.getSugar())
                    .build();
        }

        public static Nutrition toEntity(NutritionDto nutritionDto) {
            return Nutrition.builder()
                    .carbohydrates(nutritionDto.getCarbohydrates())
                    .protein(nutritionDto.getProtein())
                    .fat(nutritionDto.getFat())
                    .calories(nutritionDto.getCalories())
                    .sugar(nutritionDto.getSugar())
                    .build();
        }

    }
}
