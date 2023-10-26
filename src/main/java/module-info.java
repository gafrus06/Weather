module com.weather.weather2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens com.weather.weather2 to javafx.fxml;
    exports com.weather.weather2;
    exports com.example.weather.Controller;
    opens com.example.weather.Controller to javafx.fxml;
}