package Project.DAO;

import Project.JSONObject.RouteJSON;
import Project.controller.RouteController;
import Project.essence.Route;
import Project.essence.Station;

import java.util.ArrayList;
import java.util.List;

public class RouteDAO implements RouteController {

    List<Route> routes;
    Station startStation;
    Station finishStation;


    public List<RouteJSON> loadData(){
        return new ArrayList<RouteJSON>();
    }

    public RouteDAO() {
        routes = new ArrayList<Route>();

        Route route0 = new Route(startStation, finishStation);
        routes.add(route0);
    }

    public List<Route> printRoutes(){
        return routes;
    }

}
