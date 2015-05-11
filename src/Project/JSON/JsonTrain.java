package Project.JSON;


import Project.essence.Train;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
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

    public List<Train> jsonToObject() {

        Gson gson = new Gson();
        List<Train> trainList = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("trains.json"));

            trainList = gson.fromJson(br, List.class);

           // System.out.println(trainList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return trainList;
    }

    public void createTrain(){

        Scanner sc1 = new Scanner(System.in);
        int n = 0;
        String name;
        //int id;
        List<Train> trainList = new ArrayList<>();

        System.out.println("Enter number of trains: ");
        n = sc1.nextInt();

        Scanner sc2 = new Scanner(System.in);
        //Scanner sc3 = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            System.out.println("Enter the name of train: ");
            name = sc2.nextLine();
            //System.out.println("Enter the number of train: ");
            //id = sc3.nextInt();

            Train train = new Train();
            train.setId(i);
            train.setName(name);

            trainList.add(train);
        }
        JsonTrain jsonTrain = new JsonTrain();
        jsonTrain.objectToJson(trainList);
    }

    public void delete(){

        Scanner sc = new Scanner(System.in);
        String nameDelete;
        Gson gson = new Gson();
        List<Train> trainList = new ArrayList<>();
        Train train = new Train();

        try {

            BufferedReader br = new BufferedReader(new FileReader("trains.json"));

            trainList = gson.fromJson(br, List.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(trainList);

        System.out.println("Enter the name of the train to be deleted: ");
        nameDelete = sc.nextLine();


        Iterator<Train> iter = trainList.iterator(); //вариант 2
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

            //вариан 1
       /* for(Train tr : trainList){   //ClassCastException: com.google.gson.internal.LinkedTreeMap cannot be cast to Project.essence.Train
            if(tr.equals(nameDelete)){
                trainList.remove();
            }
            else{
                System.out.println("This train does not exist!");
            }
        }*/
    }
}
