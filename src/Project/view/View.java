package Project.view;

import Project.controller.RouteController;
import Project.controller.StationController;
import Project.controller.TrainController;

import java.util.Scanner;

public class View {

    public void display() {

        TrainController trainController = new TrainController();
        StationController stationController = new StationController();
        RouteController routeController = new RouteController();
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);
        Scanner sc5 = new Scanner(System.in);
        int n, m, p, r, q;

        for (; ; ) {
            System.out.println("1. Расписание.");
            System.out.println("2. Дополнительная информация.");
            System.out.println("3. Администрация.");
            n = sc1.nextInt();

            switch (n) {
                case 1:
                    routeController.showSchedule();
                    break;
                case 2:
                    System.out.println("1. Поезда.");
                    System.out.println("2. Станции.");
                    m = sc2.nextInt();

                    switch (m) {
                        case 1:
                            System.out.println("1. Информация об одном поезде.");
                            System.out.println("2. Вывести список всех поездов.");
                            r = sc4.nextInt();

                            switch (r) {
                                case 1:
                                    trainController.searchTrain();
                                    break;
                                case 2:
                                    trainController.getTrains();
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("1. Информация об одной станции.");
                            System.out.println("2. Вывести список всех станций.");
                            q = sc5.nextInt();

                            switch (q){
                                case 1:
                                    stationController.searchStation();
                                    break;
                                case 2:
                                    stationController.getStations();
                                    break;
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1. Cоздать список поездов.");
                    System.out.println("2. Создать список станций.");
                    System.out.println("3. Создать список маршрутов.");
                    System.out.println("4. Добавить новый поезд.");
                    System.out.println("5. Добавить новую станцию.");
                    System.out.println("6. Добавить новый маршрут.");
                    System.out.println("7. Удалить поезд.");
                    System.out.println("8. Удалить станцию.");
                    System.out.println("9. Удалить маршрут.");
                    p = sc3.nextInt();

                    switch (p) {
                        case 1:
                            trainController.createTrains();
                            break;
                        case 2:
                            stationController.createStations();
                            break;
                        case 3:
                            routeController.createShedule();
                            break;
                        case 4:
                            trainController.add();
                            break;
                        case 5:
                            stationController.add();
                            break;
                        case 6:
                            routeController.addNewRoute();
                            break;
                        case 7:
                            trainController.delete();
                            break;
                        case 8:
                            stationController.delete();
                            break;
                        case 9:
                            routeController.delete();
                            break;
                    }
                    break;
            }
            System.out.println();
        }
    }
}
