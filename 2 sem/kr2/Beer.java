package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Beer {
    int id;
    String name;
    String tagline;
//    String first_brewed;
//    String description;
//    String image_url;
    int abv;
//    double ibu;
//    double target_fg;
//    double target_og;
//    int ebc;
//    double srm;
//    double ph;
//    int attenuation_level;
//    public class Volume {
//        double value;
//        String unit;
//    }
//    Volume volume;

//        }
}
