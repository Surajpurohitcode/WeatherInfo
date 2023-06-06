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
import java.lang.reflect.Type;
import java.util.Objects;

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
    protected void onHelloButtonClick() throws IOException {
        String cityinput = Searchinput.getText();
        cityname.setText(cityinput.toUpperCase());

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://open-weather13.p.rapidapi.com/city/"+cityinput)
                .get()
                .addHeader("X-RapidAPI-Key", "28f64ecfe6msh712bebd1d1cf067p1c139ajsn6d2673c07f02")
                .addHeader("X-RapidAPI-Host", "open-weather13.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        String data = response.body().string();
        JSONObject obj = new JSONObject(data);
        JSONArray arr = obj.getJSONArray("weather");
        for (int i = 0; i < arr.length(); i++)
        {
            String cw = arr.getJSONObject(i).getString("description");
            currentweather.setText(cw);
        }
        JSONArray array = obj.getJSONArray("visibility");
        for (int i = 0; i < arr.length(); i++)
        {
            String wind = arr.getJSONObject(i).getString("speed");
            windspeed.setText(wind);
        }
    }
}