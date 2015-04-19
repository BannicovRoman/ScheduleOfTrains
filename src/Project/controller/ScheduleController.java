package Project.controller;

import Project.essence.Schedule;
import Project.view.ScheduleView;

public class ScheduleController {
    private Schedule modelSchedule;
    private ScheduleView viewSchedule;

    public ScheduleController(Schedule modelSchedule, ScheduleView viewSchedule) {
        this.modelSchedule = modelSchedule;
        this.viewSchedule = viewSchedule;
    }

    public void setDeparture(String timeDeparture){
        modelSchedule.setTimeDeparture(timeDeparture);
    }

    public String getDeparture(){
        return modelSchedule.getTimeDeparture();
    }

    public void setArrival(String timeArrival){
        modelSchedule.setTimeArrival(timeArrival);
    }

    public String getArrival(){
        return modelSchedule.getTimeArrival();
    }

    public void updateViewSchedule(){
        viewSchedule.printSchedule(modelSchedule.getTimeDeparture(), modelSchedule.getTimeArrival());
    }
}
