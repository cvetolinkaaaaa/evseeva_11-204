package ru.itis.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Table(name = "nutrition")
public class Nutrition {
    @Id
    @GeneratedValue
    private Long id;

    private Double carbohydrates;

    private Double protein;

    private Double fat;

    private Double calories;

    private Double sugar;

    @OneToOne
    @JoinColumn(name = "fruit_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Fruit fruit;
}
