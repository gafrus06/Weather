package com.example.weather.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

public class WeatherController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text feel;
    @FXML
    private Text clouds;

    @FXML
    private Text getWeather;

    @FXML
    private Text pressure;

    @FXML
    private Text temp;

    @FXML
    public TextField textField;

    @FXML
    void initialize() {
        eventMouseEnteredAndExited();
        eventMouseClicked();
    }

    private void eventMouseEnteredAndExited(){
        getWeather.setOnMouseEntered(mouseEvent -> {

            getWeather.setFill(Color.valueOf("4f2834"));
            getWeather.setStyle("-fx-font-size: 22px");
        });
        getWeather.setOnMouseExited(mouseEvent -> {
            getWeather.setFill(Color.valueOf("3b5b75"));
            getWeather.setStyle("-fx-font-size: 19px");
        });

    }

    private void eventMouseClicked(){
        getWeather.setOnMouseClicked(mouseEvent -> {
            if(!textField.getText().equals("")) {
                WeatherConnect weatherConnect = new WeatherConnect();
                String city = textField.getText();
                String output = weatherConnect.getUrlContent("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&lang=ru&appid=297bd912c413f6600ae7b351433748a6");
                if (!output.isEmpty()) {
                    JSONObject object = new JSONObject(output);
                    JSONArray weatherArray = object.getJSONArray("weather");
                    JSONObject weatherObject = weatherArray.getJSONObject(0);
                    String description = weatherObject.getString("main");
                    temp.setText("Temp: " + object.getJSONObject("main").getDouble("temp"));
                    feel.setText("Feel: " + object.getJSONObject("main").getDouble("feels_like"));
                    pressure.setText("Pressure: " + object.getJSONObject("main").getDouble("pressure"));
                    clouds.setFill(Color.valueOf("4f2834"));
                    clouds.setStyle("-fx-font-size: 19px");
                    clouds.setText(description.toUpperCase());
                }
            }

        });
    }

}
