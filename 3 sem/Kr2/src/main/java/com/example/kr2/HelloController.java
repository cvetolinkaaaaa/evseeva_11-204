package com.example.kr2;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.SneakyThrows;

import java.net.URL;

public class HelloController {
//    @FXML
//    private Label welcomeText;
//
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
    @FXML
    private TextField textField;
    @SneakyThrows
    public void getWeather(ActionEvent event){
        String cityName = textField.getText();
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid={API key}";
        createNewWindow(url);
    }

    @SneakyThrows
    public static void createNewWindow(String url) {
        ObjectMapper objectMapper = new ObjectMapper();
        CityWeather cityWeather = objectMapper.readValue(new URL(url), CityWeather.class);
        Stage window = new Stage();
        VBox pane = new VBox();
        Image image = new Image("https://openweathermap.org/img/wn/"+ cityWeather.getWeather().getIcon() + "@2x.png");
        ImageView imageView = new ImageView(image);
        pane.getChildren().add(imageView);
        Text weatherMain = new Text("Weather main: " + cityWeather.getWeather().getMain());
        Text weatherDescription = new Text("Weather description " + cityWeather.getWeather().getDescription());
        Text mainTemp = new Text(String.valueOf(cityWeather.getMain().getTemp() -  273.5));
        Text mainFeelsLike = new Text(String.valueOf(cityWeather.getMain().getFeels_like() - 273.5));
        Text mainMinTemp = new Text(String.valueOf(cityWeather.getMain().getTemp_min() - 273.5));
        Text mainMaxRemp = new Text(String.valueOf(cityWeather.getMain().getTemp_max() - 273.5));
        Text mainHumadity = new Text(String.valueOf(cityWeather.getMain().getHumidity()));
        Text mainPressure = new Text(String.valueOf(cityWeather.getMain().getPressure()));
        Text windSpeed = new Text (String.valueOf(cityWeather.getWind().getSpeed()));
        pane.getChildren().add(weatherMain);
        pane.getChildren().add(weatherDescription);
        pane.getChildren().add(mainTemp);
        pane.getChildren().add(mainFeelsLike);
        pane.getChildren().add(mainMinTemp);
        pane.getChildren().add(mainMaxRemp);
        pane.getChildren().add(mainHumadity);
        pane.getChildren().add(mainPressure);
        pane.getChildren().add(windSpeed);
        Scene scene = new Scene(pane,300,300 );
        window.setScene(scene);
        window.setTitle("Weather");
        window.show();
    }
}