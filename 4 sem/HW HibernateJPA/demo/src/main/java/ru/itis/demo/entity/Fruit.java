package ru.itis.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Table(name = "fruit")
public class Fruit {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "fruit")
    private Nutrition nutrition;
}
