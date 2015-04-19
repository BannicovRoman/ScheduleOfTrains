package Project.controller;

import Project.essence.Route;
import Project.essence.Station;
import Project.view.StationView;

public class StationController {
    private Station modulStation;
    private StationView viewStation;

    public StationController(Station modulStation, StationView viewStation) {
        this.modulStation = modulStation;
        this.viewStation = viewStation;
    }

    public void setStStation(String startStation){
        modulStation.setStartStation(startStation);
    }

    public String getStStation(){
        return modulStation.getStartStation();
    }

    public void setFinStation(String finishStation){
        modulStation.setFinishStation(finishStation);
    }

    public String getFinStation(){
        return modulStation.getFinishStation();
    }

    public void updateViewStation(){
        viewStation.printStation(modulStation.getStartStation(), modulStation.getFinishStation());
    }
}
