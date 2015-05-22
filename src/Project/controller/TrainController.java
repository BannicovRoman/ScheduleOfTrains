package Project.controller;

import Project.JSON.JsonTrain;

public class TrainController {

    public void createTrains(){
        JsonTrain jsonTrain = new JsonTrain();
        jsonTrain.createListTrain();
    }

    public void searchTrain(){
        JsonTrain jsonTrain = new JsonTrain();
        jsonTrain.search();
    }

    public void getTrains(){
        JsonTrain jsonTrain = new JsonTrain();
        jsonTrain.getAllTrains();
    }

    public void add(){
        JsonTrain jsonTrain = new JsonTrain();
        jsonTrain.addTrain();
    }

    public void delete(){
        JsonTrain jsonTrain = new JsonTrain();
        jsonTrain.deleteTrain();
    }

}