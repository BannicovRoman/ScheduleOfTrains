package Project.JSON;

import Project.essence.Station;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JsonStation {

    public void objectToJson(List<Station> stationList) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(stationList);

        BufferedWriter bufferedWriter = null;
        try {

            File file = new File("stations.json");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(jsonString);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<Station> jsonToObject() {

        Gson gson = new Gson();
        List<Station> stationList = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("stations.json"));

            stationList = gson.fromJson(br, List.class);

            System.out.println(stationList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stationList;
    }

    public void createListStations(){

        Scanner sc1 = new Scanner(System.in);
        int n;
        int id;
        String name;
        String timeParking;
        List<Station> stationList = new ArrayList<>();

        System.out.println("Введите количество станций для создания списка: ");
        n = sc1.nextInt();

        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            System.out.println("Введите номер станции: ");
            id = sc4.nextInt();
            System.out.println("Введите название станции: ");
            name = sc2.nextLine();
            System.out.println("Введите время стоянки: ");
            timeParking = sc3.nextLine();

            Station station = new Station();
            station.setId(id);
            station.setName(name);
            station.setTimeParking(timeParking);

            stationList.add(station);
        }
        JsonStation jsonStation = new JsonStation();
        jsonStation.objectToJson(stationList);
    }

    public void search(){

        Scanner sc = new Scanner(System.in);
        String name;
        Gson gson = new Gson();
        JsonArray jsonArray = new JsonArray();

        try {

            BufferedReader br = new BufferedReader(new FileReader("stations.json"));

            jsonArray = gson.fromJson(br, JsonArray.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Пожалуйста, введите название станции:");
        name = sc.nextLine();

        for(int i = 0; i < jsonArray.size(); i++) {
            String n = jsonArray.get(i).getAsJsonObject().get("name").getAsString();
            if (n.equals(name)) {
                System.out.println(jsonArray.get(i).getAsJsonObject());
            }
        }
    }

    public void getAllStations(){

        Gson gson = new Gson();
        JsonArray  jsonArray = new JsonArray();

        try {

            BufferedReader br = new BufferedReader(new FileReader("stations.json"));

            jsonArray = gson.fromJson(br, JsonArray.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.get(i).getAsJsonObject());
        }
    }

    public void addStation(){

        Gson gson = new Gson();
        List<Station> stationList = new LinkedList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("stations.json"));

            stationList = gson.fromJson(br, List.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        int id;
        String name;
        String timeParking;

        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc5 = new Scanner(System.in);

        System.out.println("Введите номер станции: ");
        id = sc5.nextInt();
        System.out.println("Введите название станции: ");
        name = sc2.nextLine();
        System.out.println("Введите время стоянки: ");
        timeParking = sc3.nextLine();

        Station station = new Station();
        station.setId(id);
        station.setName(name);
        station.setTimeParking(timeParking);

        stationList.add(station);

    JsonStation jsonStation = new JsonStation();
    jsonStation.objectToJson(stationList);
    }

    public void deleteStation(){

        Scanner sc = new Scanner(System.in);
        String nameDelete;
        Gson gson = new Gson();
        JsonArray  jsonArray = new JsonArray();

        try {

            BufferedReader br = new BufferedReader(new FileReader("stations.json"));

            jsonArray = gson.fromJson(br, JsonArray.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Введите название станции для удаления: ");
        nameDelete = sc.nextLine();

        for(int i = 0; i < jsonArray.size(); i++) {
            String name = jsonArray.get(i).getAsJsonObject().get("name").getAsString();
            if(name.equals(nameDelete)){
                jsonArray.remove(i);
            }
        }
        Gson gsonWr = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gsonWr.toJson(jsonArray);

        BufferedWriter bufferedWriter = null;
        try {

            File file = new File("stations.json");
            if(!file.exists()){
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(jsonString);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null){
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
