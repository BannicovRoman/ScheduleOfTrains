package Project.essence;

import java.util.Map;

public class Route {

    public Station startStation;
    public Station finishStation;
    Map<Integer,String> betweenStation;

    public Station getStartStation() {
        return startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public Station getFinishStation() {
        return finishStation;
    }

    public void setFinishStation(Station finishStation) {
        this.finishStation = finishStation;
    }

    public Map<Integer, String> getBetweenStation() {
        return betweenStation;
    }

    public void setBetweenStation(Map<Integer, String> betweenStation) {
        this.betweenStation = betweenStation;
    }
}
