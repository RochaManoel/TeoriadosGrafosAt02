package Auxiliares;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Input {
    
    public Input(ArrayList<City> listCities){
        JSONParser jsonParser = new JSONParser();
        try(FileReader arq = new FileReader("cities.json")){

            Object obj = jsonParser.parse(arq);
            JSONArray listCidades = (JSONArray) obj;
            listCidades.forEach(cidade -> {
                JSONObject object = (JSONObject) cidade;
                parserCidadesInfo(object, listCities);
            });
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    private void parserCidadesInfo(JSONObject cidade, ArrayList<City> list){
        String city  = cidade.get("city").toString();
        String growth  = cidade.get("growth_from_2000_to_2013").toString();
        float latitude = Float.parseFloat(cidade.get("latitude").toString());
        float longitude = Float.parseFloat(cidade.get("longitude").toString());
        int population  = Integer.parseInt(cidade.get("population").toString());
        int rank  = Integer.parseInt(cidade.get("rank").toString());
        String state  = cidade.get("state").toString();

        City date = new City(city, growth, latitude, longitude, population, rank, state);
        list.add(date);
    }

}
