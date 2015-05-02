package Project.essence;

public class Route {

    private Station startStation;
    private Station finishStation;


    public Route(Station startStation, Station finishStation) {
        this.startStation = startStation;
        this.finishStation = finishStation;
    }

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
}


