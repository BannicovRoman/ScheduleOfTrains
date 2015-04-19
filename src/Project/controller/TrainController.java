package Project.controller;

import Project.essence.Train;
import Project.view.TrainView;

public class TrainController {

    private Train modelTrain;
    private TrainView viewTrain;

    public TrainController(Train modelTrain, TrainView viewTrain) {
        this.modelTrain = modelTrain;
        this.viewTrain = viewTrain;
    }

    public void setTrainNumber(int num) {

        modelTrain.setNumber(num);
    }

    public int getTrainModeDriving(){

        return modelTrain.getNumber();
    }

    public void setTrainMode(String drivingMode){

        modelTrain.setDrivingMode(drivingMode);
    }

    public String getTrainMode(){

        return modelTrain.getDrivingMode();
    }
    public void updateViewTrain(){
        viewTrain.printTrainNum(modelTrain.getNumber());
        viewTrain.printTrainMode(modelTrain.getDrivingMode());
    }



}
