package Project.DAO;

import Project.controller.TrainController;
import Project.essence.Train;

import java.util.ArrayList;
import java.util.List;

public class TrainDAO implements TrainController {

    List<Train> trains;

    public TrainDAO(){
        trains = new ArrayList<Train>();
        Train train1 = new Train("Fast train", 0);
        Train train2 = new Train("Freight train", 1);
        Train train3 = new Train("Local train", 2);
        Train train4 = new Train("Speeding train", 3);
        trains.add(train1);
        trains.add(train2);
        trains.add(train3);
        trains.add(train4);
    }

    public void deleteTrain(Train train){
        trains.remove(train.getNumber());
        System.out.println("Train with number " + train.getNumber() + " was deleted from database.");
    }

    public void updateTrain(Train train){
        trains.get(train.getNumber()).setName(train.getName());
        System.out.println("Train with number " + train.getNumber() + " was updated in the database.");
    }

    public List<Train> printTrains() {
        return trains;
    }

    public String getTrain(int number){
        return trains.get(number).getName();
    }
}
