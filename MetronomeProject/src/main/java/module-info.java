module com.example.metronomeproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.metronomeproject to javafx.fxml;
    exports com.example.metronomeproject;
}