package com.example.weatherinfo;
import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.ws.RealWebSocket;
import org.json.*;
import java.io.IOException;



public class HelloController {
    @FXML
    private TextField Searchinput;

    @FXML
    private Label cityname;

    @FXML
    private Label currentweather;

    @FXML
    private Label timezone;

    @FXML
    private Label windspeed;
    @FXML
    private Label country;
    @FXML
    private Label state;
    @FXML
    private Label temp;
    @FXML
    private Label humidity;
    @FXML
    private Label last_updated;

    @FXML
    private ImageView weatherimage;
    String apiKey = "002086817c6920c2dd802bdf06b9e0a3";

    @FXML
    protected void onHelloButtonClick() throws IOException {
        String cityinput = Searchinput.getText();
        cityname.setText(cityinput.toUpperCase());

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://api.weatherapi.com/v1/current.json?key=1d7ca7ca665c4e3ba69130346230706&q="+cityname+"&aqi=no")
                .build();

        Response response = client.newCall(request).execute();
        String data = response.body().string();
        JSONObject obj = new JSONObject(data);
        String cw = obj.getJSONObject("current").getJSONObject("condition").get("text").toString();
        currentweather.setText(cw);
        String time = obj.getJSONObject("location").get("localtime").toString();
        timezone.setText(time);
        String wind  = obj.getJSONObject("current").get("wind_kph").toString();
        windspeed.setText(wind+"km");
        country.setText(obj.getJSONObject("location").get("country").toString());
        state.setText(obj.getJSONObject("location").get("region").toString());
        temp.setText(obj.getJSONObject("current").get("temp_c").toString());
        humidity.setText(obj.getJSONObject("current").get("humidity").toString());
        last_updated.setText(obj.getJSONObject("current").get("last_updated").toString());

    }
}