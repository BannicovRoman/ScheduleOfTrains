package Project;


import Project.controller.ScheduleController;
import Project.controller.StationController;
import Project.controller.TrainController;
import Project.essence.Schedule;
import Project.essence.Station;
import Project.essence.Train;
import Project.view.ScheduleView;
import Project.view.StationView;
import Project.view.TrainView;

public class Main {
    public static void main(String[] args) {

        Train modelTrain = retrieveTrain();
        Schedule modelSchedule = retrieveSchedule();
        Station modelStation = retrieveStation();

        TrainView viewTrain = new TrainView();
        ScheduleView viewSchedule = new ScheduleView();
        StationView viewStation = new StationView();

        TrainController controllerTrain = new TrainController(modelTrain, viewTrain);
        ScheduleController controllerSchedule = new ScheduleController(modelSchedule, viewSchedule);
        StationController controllerStation = new StationController(modelStation, viewStation);

        controllerTrain.updateViewTrain();
        controllerSchedule.updateViewSchedule();
        controllerStation.updateViewStation();

        System.out.println();

        /*modelTrain.setNumber(199);
        modelTrain.setDrivingMode("Work days");
        modelStation.setStartStation("Volgograd");
        modelStation.setFinishStation("Kazan");
        modelSchedule.setTimeDeparture("10:00");
        modelSchedule.setTimeArrival("19:15");
        controllerTrain.updateViewTrain();
        controllerSchedule.updateViewSchedule();
        controllerStation.updateViewStation(); */
    }

    private  static Train retrieveTrain() {

        Train train = new Train();
        train.setNumber(153);
        train.setDrivingMode("Weekends");
        return train;
    }

    private static Schedule retrieveSchedule(){

        Schedule schedule = new Schedule();
        schedule.setTimeDeparture("12:00");
        schedule.setTimeArrival("18:30");
        return schedule;
    }

    private static Station retrieveStation(){

        Station station = new Station();
        station.setStartStation("Saratov");
        station.setFinishStation("Moscow");
        return station;
    }
}
