package Project.JSON;


import Project.essence.Train;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.io.*;
import java.util.*;

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
        List<Train> trainList = new LinkedList<>();
        //JsonArray  jsonArray = new JsonArray();

        try {

            BufferedReader br = new BufferedReader(new FileReader("trains.json"));

            //jsonArray = gson.fromJson(br, JsonArray.class);
            trainList = gson.fromJson(br, List.class);

           // System.out.println(trainList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return trainList;
    }

   /* public LinkedList<Train> jsonToObject(){

        Gson gson = new Gson();
        LinkedList<Train> trainLinkedList = new LinkedList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader("trains.json"));

            trainLinkedList = gson.fromJson(br, LinkedList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trainLinkedList;
    }*/

    public void createListTrain(){

        Scanner sc1 = new Scanner(System.in);
        int n;
        int id;
        String name;
        String machinist;
        int numberOfCoach;
        List<Train> trainList = new LinkedList<>();

        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);
        Scanner sc5 = new Scanner(System.in);

        System.out.println("Введите количество поездов для создания: ");
        n = sc1.nextInt();

        for(int i = 0; i < n; i++) {
            System.out.println("Введите номер поезда: ");
            id = sc5.nextInt();
            System.out.println("Введите название поезда: ");
            name = sc2.nextLine();
            System.out.println("Введите имя и фамилию машиниста: ");
            machinist = sc3.nextLine();
            System.out.println("Введите количество вагонов: ");
            numberOfCoach = sc4.nextInt();

            Train train = new Train();
            train.setId(id);
            train.setName(name);
            train.setMachinist(machinist);
            train.setNumberOfCoach(numberOfCoach);

            trainList.add(train);
        }
        JsonTrain jsonTrain = new JsonTrain();
        jsonTrain.objectToJson(trainList);
    }

    public void search(){

        Scanner sc = new Scanner(System.in);
        String name;
        Gson gson = new Gson();
        JsonArray  jsonArray = new JsonArray();

        try {

            BufferedReader br = new BufferedReader(new FileReader("trains.json"));

            jsonArray = gson.fromJson(br, JsonArray.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Пожалуйста, введите название поезда:");
        name = sc.nextLine();

        for(int i = 0; i < jsonArray.size(); i++) {
            String n = jsonArray.get(i).getAsJsonObject().get("name").getAsString();
            if (n.equals(name)) {
                System.out.println(jsonArray.get(i).getAsJsonObject());
            }
        }
    }

    public void getAllTrains(){

        Gson gson = new Gson();
        JsonArray  jsonArray = new JsonArray();

        try {

            BufferedReader br = new BufferedReader(new FileReader("trains.json"));

            jsonArray = gson.fromJson(br, JsonArray.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.get(i).getAsJsonObject());
        }
    }

    public void addTrain(){

        Gson gson = new Gson();
        List<Train> trainList = new LinkedList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("trains.json"));

            trainList = gson.fromJson(br, List.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        int id;
        String name;
        String machinist;
        int numberOfCoach;

        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);
        Scanner sc5 = new Scanner(System.in);

        System.out.println("Введите номер поезда: ");
        id = sc5.nextInt();
        System.out.println("Введите название поезда: ");
        name = sc2.nextLine();
        System.out.println("Введите имя и фамилию машиниста: ");
        machinist = sc3.nextLine();
        System.out.println("Введите количество вагонов: ");
        numberOfCoach = sc4.nextInt();

        Train train = new Train();
        train.setId(id);
        train.setName(name);
        train.setMachinist(machinist);
        train.setNumberOfCoach(numberOfCoach);

        trainList.add(train);

        JsonTrain jsonTrain = new JsonTrain();
        jsonTrain.objectToJson(trainList);
    }

    public void deleteTrain(){

        Scanner sc = new Scanner(System.in);
        String nameDelete;
        Gson gson = new Gson();
        JsonArray  jsonArray = new JsonArray();

        try {

            BufferedReader br = new BufferedReader(new FileReader("trains.json"));

            jsonArray = gson.fromJson(br, JsonArray.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Введите название поезда для удаления: ");
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
}
