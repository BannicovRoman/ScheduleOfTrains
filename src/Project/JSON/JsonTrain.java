package Project.JSON;


import Project.essence.Train;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonTrain{

    public void objectToJson(List<Train> trainList){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(trainList);

        BufferedWriter bufferedWriter = null;
        try {

            File file = new File("trains.json");
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

    public void jsonToObject() {

        Gson gson = new Gson();

        try {

            BufferedReader br = new BufferedReader(new FileReader("trains.json"));

            List<Train> trainList = gson.fromJson(br, List.class);

           // System.out.println(trainList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createTrain(){

        Scanner sc = new Scanner(System.in);
        int id;
        String name;
        Train train = new Train();
        List<Train> trainList = new ArrayList<>();

        System.out.println("Enter the name of train number:");
        name = sc.nextLine();
        System.out.println("Enter the number of train:");
        id = sc.nextInt();

        train.setId(id);
        train.setName(name);

        trainList.add(train);

        JsonTrain jsonTrain = new JsonTrain();
        jsonTrain.objectToJson(trainList);

    }

    public void search(){

        Scanner sc = new Scanner(System.in);
        String name;


    }

    public void delete(){

        Scanner sc = new Scanner(System.in);
        String name;
        Train train = new Train();
        List<Train> trainList = new ArrayList<>();

        JsonTrain jsonTrain = new JsonTrain();
        jsonTrain.jsonToObject();

        System.out.println("Enter the name of the train to be deleted");
        name = sc.nextLine();


        jsonTrain.objectToJson(trainList);
    }

}
