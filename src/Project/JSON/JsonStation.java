package Project.JSON;

import Project.essence.Station;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.List;

public class JsonStation {

    public void objectToJson(List<Station> stationList) {

        Station station1 = new Station();
        station1.setId(0);
        station1.setName("Reznay");

        Station station2 = new Station();
        station2.setId(1);
        station2.setName("Novay");

        Station station3 = new Station();
        station3.setId(2);
        station3.setName("Sokolovay");

        stationList.add(station1);
        stationList.add(station2);
        stationList.add(station3);

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

    public void jsonToObject() {

        Gson gson = new Gson();

        try {

            BufferedReader br = new BufferedReader(new FileReader("stations.json"));

            List<Station> stationList = gson.fromJson(br, List.class);

            System.out.println(stationList);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
