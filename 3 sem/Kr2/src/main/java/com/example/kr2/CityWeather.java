package com.example.kr2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CityWeather {
    Coord coord;
    Weather weather;
    String base;
    Main main;
    int visibility;
    Wind wind;
    Clouds clouds;
    long dt;
    Sys sys;
    int timezone;
    long id;
    String name;
    int cod;
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    static class Coord {
        Double lon;
        Double lat;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    static class Weather {
        int id;
        String main;
        String description;
        String icon;

    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    static class Main{
        Double temp;
        Double feels_like;
        Double temp_min;
        Double temp_max;
        Double pressure;
        Double humidity;
        Double sea_level;
        Double grnd_level;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    static class Wind {
        Double speed;
        Double deg;
        Double gust;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    static class Clouds {
        int all;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    static class Sys {
        int type;
        long id;
        String country;
        long sunrise;
        long sunset;
    }
}
