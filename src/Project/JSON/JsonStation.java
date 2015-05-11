package Project.JSON;

import Project.essence.Station;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
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

    public void createStation(){

        Scanner sc1 = new Scanner(System.in);
        int n = 0;
        String name;
        //int id;
        List<Station> stationList = new ArrayList<>();

        System.out.println("Enter number of stations: ");
        n = sc1.nextInt();

        Scanner sc2 = new Scanner(System.in);
        //Scanner sc3 = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            System.out.println("Enter the name of station: ");
            name = sc2.nextLine();
           // System.out.println("Enter the number of station: ");
           // id = sc3.nextInt();

            Station station = new Station();
            station.setId(i);
            station.setName(name);

            stationList.add(station);
        }
        JsonStation jsonStation = new JsonStation();
        jsonStation.objectToJson(stationList);
    }

}
