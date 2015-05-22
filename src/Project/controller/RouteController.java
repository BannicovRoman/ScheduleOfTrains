package Project.controller;

import Project.JSON.JsonRoute;

public class RouteController {

    public void showSchedule(){
        JsonRoute jsonRoute = new JsonRoute();
        jsonRoute.getSchedule();
    }

    public void createShedule(){
        JsonRoute jsonRoute = new JsonRoute();
        jsonRoute.createListRoute();
    }

    public void addNewRoute(){
        JsonRoute jsonRoute = new JsonRoute();
        jsonRoute.addRoute();
    }

    public void delete(){
        JsonRoute jsonRoute = new JsonRoute();
        jsonRoute.deleteRoute();
    }
}
