module com.example.kr2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires com.fasterxml.jackson.databind;


    opens com.example.kr2 to javafx.fxml;
    exports com.example.kr2;
}