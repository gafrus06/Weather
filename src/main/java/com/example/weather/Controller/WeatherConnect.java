package com.example.weather.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;



public class WeatherConnect {

    public String getUrlContent(String urlAddres){
        StringBuffer content = new StringBuffer();

        try{
            URL url = new URL(urlAddres);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch (Exception e) {
            System.out.println("Error");
        }
        return content.toString();
    }
}
