module com.example.weatherinfo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires okhttp3;
    requires com.google.gson;
    requires org.json;
    requires java.desktop;

    opens com.example.weatherinfo to javafx.fxml;
    exports com.example.weatherinfo;
}