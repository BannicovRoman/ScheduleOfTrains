package Project.DAO;

import Project.controller.StationController;
import Project.essence.Station;

import java.util.ArrayList;
import java.util.List;

public class StationDAO implements StationController {

    List<Station> stations;

    public StationDAO(){
        stations = new ArrayList<Station>();
        Station station0 = new Station(0, "Station_0");
        Station station1 = new Station(1, "Station_1");
        Station station2 = new Station(2, "Station_2");
        Station station3 = new Station(3, "Station_3");
        Station station4 = new Station(4, "Station_4");
        Station station5 = new Station(5, "Station_5");
        Station station6 = new Station(6, "Station_6");
        stations.add(station0);
        stations.add(station1);
        stations.add(station2);
        stations.add(station3);
        stations.add(station4);
        stations.add(station5);
        stations.add(station6);
    }

    public void deleteStation(Station station){
        stations.remove(station.getId());
        System.out.println("Station with number " + station.getId() + " was deleted from database.");
    }

    public void updateStation(Station station){
        stations.get(station.getId()).setName(station.getName());
        System.out.println("Station with number " + station.getId() + " was updated in the database.");
    }

    public List<Station> printStations() {
        return stations;
    }

    public String getStation(int id){
        return stations.get(id).getName();
    }
}
