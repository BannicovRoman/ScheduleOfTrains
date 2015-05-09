package Project.controller;

import Project.essence.Station;
import Project.view.StationView;

public class StationController {
    private Station modelStation;
    private StationView viewStation;

    public StationController(Station modelStation, StationView viewStation) {
        this.modelStation = modelStation;
        this.viewStation = viewStation;
    }

    public void setStationId(int id) {

        modelStation.setId(id);
    }

    public int getStationId(){

        return modelStation.getId();
    }

    public void setStationName(String name){

        modelStation.setName(name);
    }

    public String getStationName(){

        return modelStation.getName();
    }
    public void updateViewStation(){
        viewStation.printStationId(modelStation.getId());
        viewStation.printStationName(modelStation.getName());
    }
}