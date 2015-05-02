package Project.controller;

import Project.essence.Station;

import java.util.List;

public interface StationController {

    public List<Station> printStations();
    public String getStation(int id);
    public void updateStation(Station station);
    public void deleteStation(Station station);
}
