package com.bootcamp.challenge.test.consumer;

import com.bootcamp.challenge.test.exception.ErrorInDistrictsApiException;
import com.bootcamp.challenge.test.exception.ErrorInReadDistrictsApiException;
import com.bootcamp.challenge.test.model.District;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.List;

public class DistrictsApi {

    public static List<District> listDistricts(){
        Gson gson = new Gson();
        JsonArray convertedJson = new Gson().fromJson(apiDistritos(), JsonArray.class);
        Type collectionType = new TypeToken<Collection<District>>(){}.getType();
        List<District> districts = gson.fromJson(convertedJson, collectionType);
        return districts;
    }

    public static String apiDistritos(){
        try {
            java.lang.String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/35/distritos";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();

            if (responseCode == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine = br.readLine();
                return inputLine;
            } else {
                throw new ErrorInDistrictsApiException("Error na api de Distritos.");
            }
        } catch (IOException e) {
            throw new ErrorInReadDistrictsApiException("Error verifique se a URI da api de Distritos informada esta correta.");
        }
    }

}
