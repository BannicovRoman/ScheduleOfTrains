package Project.JSON;

import Project.essence.Route;
import Project.essence.Station;
import Project.essence.Train;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JsonRoute {

   public void objectToJson(List<Route> routeList){

      Gson gson = new GsonBuilder().setPrettyPrinting().create();

      String jsonString = gson.toJson(routeList);

      BufferedWriter bufferedWriter = null;
      try {

         File file = new File("routes.json");
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

   public List<Route> jsonToObject() {

      Gson gson = new Gson();
      List<Route> routeList = new LinkedList<>();

      try {

         BufferedReader br = new BufferedReader(new FileReader("routes.json"));

         routeList = gson.fromJson(br, List.class);

      } catch (IOException e) {
         e.printStackTrace();
      }
      return routeList;
   }

   public void createListRoute(){

      Scanner sc1 = new Scanner(System.in);
      int n;
      int id;
      String timeOut;
      String timeIn;
      List<Route> routeList = new LinkedList<>();
      String nameTrain;
      String startStation;
      String finishStation;

      Scanner sc2 = new Scanner(System.in);
      Scanner sc3 = new Scanner(System.in);
      Scanner sc4 = new Scanner(System.in);
      Scanner sc5 = new Scanner(System.in);
      Scanner sc6 = new Scanner(System.in);
      Scanner sc7 = new Scanner(System.in);

      System.out.println("Введите количество маршрутов для создания: ");
      n = sc1.nextInt();

      for(int i = 0; i < n; i++){
         System.out.println("Введите номер маршрута: ");
         id = sc2.nextInt();

         System.out.println("Выберите поезд и введите его название: ");
         JsonTrain jsonTrain = new JsonTrain();
         jsonTrain.getAllTrains();
         nameTrain = sc3.nextLine();

         Gson gsonTrain = new Gson();
         JsonArray jsonArrayTrain = new JsonArray();
         Train train = new Train();

         try {

            BufferedReader br = new BufferedReader(new FileReader("trains.json"));

            jsonArrayTrain = gsonTrain.fromJson(br, JsonArray.class);

         } catch (IOException e) {
            e.printStackTrace();
         }

         for(int j = 0; j < jsonArrayTrain.size(); j++) {
            String name = jsonArrayTrain.get(j).getAsJsonObject().get("name").getAsString();
            if (name.equals(nameTrain)) {
               train.setId(jsonArrayTrain.get(j).getAsJsonObject().get("id").getAsInt());
               train.setName(nameTrain);
               train.setMachinist(jsonArrayTrain.get(j).getAsJsonObject().get("machinist").getAsString());
               train.setNumberOfCoach(jsonArrayTrain.get(j).getAsJsonObject().get("numberOfCoach").getAsInt());
            }
         }

         System.out.println("Выберите начальную станцию и введите её название: ");
         JsonStation jsonStation = new JsonStation();
         jsonStation.getAllStations();
         startStation = sc4.nextLine();

         Gson gsonStation = new Gson();
         JsonArray jsonArrayStation = new JsonArray();
         Station stationSt = new Station();
         Station stationFin = new Station();

         try {

            BufferedReader br = new BufferedReader(new FileReader("stations.json"));

            jsonArrayStation = gsonStation.fromJson(br, JsonArray.class);

         } catch (IOException e) {
            e.printStackTrace();
         }

         for(int q = 0; q < jsonArrayStation.size(); q++) {
            String nameStStation = jsonArrayStation.get(q).getAsJsonObject().get("name").getAsString();
            if (nameStStation.equals(startStation)) {
               stationSt.setId(jsonArrayStation.get(q).getAsJsonObject().get("id").getAsInt());
               stationSt.setName(startStation);
               stationSt.setTimeParking(jsonArrayStation.get(q).getAsJsonObject().get("timeParking").getAsString());
            }
         }

         System.out.println("Выберите конечную станцию и введите её название: ");
         finishStation = sc5.nextLine();

         for(int p = 0; p < jsonArrayStation.size(); p++) {
            String nameFinStation = jsonArrayStation.get(p).getAsJsonObject().get("name").getAsString();
            if (nameFinStation.equals(finishStation)) {
               stationFin.setId(jsonArrayStation.get(p).getAsJsonObject().get("id").getAsInt());
               stationFin.setName(finishStation);
               stationFin.setTimeParking(jsonArrayStation.get(p).getAsJsonObject().get("timeParking").getAsString());
            }
         }

         System.out.println("Введите время отправления: ");
         timeOut = sc6.nextLine();

         System.out.println("Введите время прибытия: ");
         timeIn = sc7.nextLine();

         Route route = new Route();
        // Train train = (Train) jsonTrain.jsonToObject().get(idTrain);

         route.setId(id);

         route.setTrain(train);

         route.setStartStation(stationSt);

         route.setFinishStation(stationFin);

         route.setTimeOut(timeOut);
         route.setTimeIn(timeIn);

         routeList.add(route);
      }
      JsonRoute jsonRoute = new JsonRoute();
      jsonRoute.objectToJson(routeList);
   }

   public void getSchedule(){

      Gson gson = new Gson();
      JsonArray  jsonArray = new JsonArray();

      try {

         BufferedReader br = new BufferedReader(new FileReader("routes.json"));

         jsonArray = gson.fromJson(br, JsonArray.class);

      } catch (IOException e) {
         e.printStackTrace();
      }

      for(int i = 0; i < jsonArray.size(); i++) {
         System.out.println(i + ". " + "Поезд: " + jsonArray.get(i).getAsJsonObject().get("train").getAsJsonObject().get("name").getAsString() +
                 "\t Начальная станция: " + jsonArray.get(i).getAsJsonObject().get("startStation").getAsJsonObject().get("name").getAsString() +
                 "\t Время отправления: " + jsonArray.get(i).getAsJsonObject().get("timeOut").getAsString() +
                 "\t Конечная станция: " + jsonArray.get(i).getAsJsonObject().get("finishStation").getAsJsonObject().get("name").getAsString() +
                 "\t Время прибытия: " + jsonArray.get(i).getAsJsonObject().get("timeIn").getAsString());
      }
   }

   public void addRoute(){

      Gson gson = new Gson();
      List<Route> routeList = new LinkedList<>();

      try {

         BufferedReader br = new BufferedReader(new FileReader("routes.json"));

         routeList = gson.fromJson(br, List.class);

      } catch (IOException e) {
         e.printStackTrace();
      }

      int n;
      int id;
      String timeOut;
      String timeIn;
      String nameTrain;
      String startStation;
      String finishStation;

      Scanner sc2 = new Scanner(System.in);
      Scanner sc3 = new Scanner(System.in);
      Scanner sc4 = new Scanner(System.in);
      Scanner sc5 = new Scanner(System.in);
      Scanner sc6 = new Scanner(System.in);
      Scanner sc7 = new Scanner(System.in);

      System.out.println("Введите номер маршрута: ");
      id = sc2.nextInt();

      System.out.println("Выберите поезд и введите его название: ");
      JsonTrain jsonTrain = new JsonTrain();
      jsonTrain.getAllTrains();
      nameTrain = sc3.nextLine();

      Gson gsonTrain = new Gson();
      JsonArray jsonArrayTrain = new JsonArray();
      Train train = new Train();

      try {

         BufferedReader br = new BufferedReader(new FileReader("trains.json"));

         jsonArrayTrain = gsonTrain.fromJson(br, JsonArray.class);

      } catch (IOException e) {
         e.printStackTrace();
      }

      for(int j = 0; j < jsonArrayTrain.size(); j++) {
         String name = jsonArrayTrain.get(j).getAsJsonObject().get("name").getAsString();
         if (name.equals(nameTrain)) {
            train.setId(jsonArrayTrain.get(j).getAsJsonObject().get("id").getAsInt());
            train.setName(nameTrain);
            train.setMachinist(jsonArrayTrain.get(j).getAsJsonObject().get("machinist").getAsString());
            train.setNumberOfCoach(jsonArrayTrain.get(j).getAsJsonObject().get("numberOfCoach").getAsInt());
         }
      }

      System.out.println("Выберите начальную станцию и введите её название: ");
      JsonStation jsonStation = new JsonStation();
      jsonStation.getAllStations();
      startStation = sc4.nextLine();

      Gson gsonStation = new Gson();
      JsonArray jsonArrayStation = new JsonArray();
      Station stationSt = new Station();
      Station stationFin = new Station();

      try {

         BufferedReader br = new BufferedReader(new FileReader("stations.json"));

         jsonArrayStation = gsonStation.fromJson(br, JsonArray.class);

      } catch (IOException e) {
         e.printStackTrace();
      }

      for(int q = 0; q < jsonArrayStation.size(); q++) {
         String nameStStation = jsonArrayStation.get(q).getAsJsonObject().get("name").getAsString();
         if (nameStStation.equals(startStation)) {
            stationSt.setId(jsonArrayStation.get(q).getAsJsonObject().get("id").getAsInt());
            stationSt.setName(startStation);
            stationSt.setTimeParking(jsonArrayStation.get(q).getAsJsonObject().get("timeParking").getAsString());
         }
      }

      System.out.println("Выберите конечную станцию и введите её название: ");
      finishStation = sc5.nextLine();

      for(int p = 0; p < jsonArrayStation.size(); p++) {
         String nameFinStation = jsonArrayStation.get(p).getAsJsonObject().get("name").getAsString();
         if (nameFinStation.equals(finishStation)) {
            stationFin.setId(jsonArrayStation.get(p).getAsJsonObject().get("id").getAsInt());
            stationFin.setName(finishStation);
            stationFin.setTimeParking(jsonArrayStation.get(p).getAsJsonObject().get("timeParking").getAsString());
         }
      }

      System.out.println("Введите время отправления: ");
      timeOut = sc6.nextLine();

      System.out.println("Введите время прибытия: ");
      timeIn = sc7.nextLine();

      Route route = new Route();

      route.setId(id);

      route.setTrain(train);

      route.setStartStation(stationSt);

      route.setFinishStation(stationFin);

      route.setTimeOut(timeOut);
      route.setTimeIn(timeIn);

      routeList.add(route);

      JsonRoute jsonRoute = new JsonRoute();
      jsonRoute.objectToJson(routeList);

   }
   }
