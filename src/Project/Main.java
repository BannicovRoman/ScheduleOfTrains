package Project;

import Project.DAO.RouteDAO;
import Project.controller.RouteController;
import Project.essence.Route;

public class Main {
    public static void main(String[] args) {

       // TrainController train = new TrainDAO();
        RouteController route = new RouteDAO();
       // StationController station = new StationDAO();

       /* for (Station st : station.printStations()) { //выводим весь список станций
            System.out.println(st.getName());
            }

        System.out.println();
        System.out.println(station.getStation(1)); //выводи станцию по номеру
        */

       /*for (Train tr : train.printTrains()) { //выводим весь список поездов
            System.out.println(tr.getName());
            }
        System.out.println();
        System.out.println(train.getTrain(1)); //выводим название поезда по номеру
        System.out.println();

        Train up = train.printTrains().get(2); //обновляем название поезда по номеру
        up.setName("VIP train");
        train.updateTrain(up);*/


        for (Route r : route.printRoutes()) {
            System.out.println(r);
        }
    }
}
