package Project.controller;

import Project.essence.Train;

import java.util.List;

public interface TrainController {

    public List<Train> printTrains();
    public String getTrain(int number);
    public void updateTrain(Train train);
    public void deleteTrain(Train train);
}

