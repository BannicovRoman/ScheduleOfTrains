package Project.controller;

import Project.JSON.JsonStation;

public class StationController {

    public void createStations(){
        JsonStation jsonStation = new JsonStation();
        jsonStation.createListStations();
    }

    public void searchStation(){
        JsonStation jsonStation = new JsonStation();
        jsonStation.search();
    }

    public void getStations(){
        JsonStation jsonStation = new JsonStation();
        jsonStation.getAllStations();
    }

    public void add(){
        JsonStation jsonStation = new JsonStation();
        jsonStation.addStation();
    }
}