package models;

public class Street {
    String name;
    int timeToStreetEnd;
    int intersectionEnd;
    int intersectionStart;
    TrafficLight streetLight;


    public Street(String[] streetDetails) {
        this.intersectionStart = Integer.parseInt(streetDetails[0]);
        this.intersectionEnd = Integer.parseInt(streetDetails[1]);
        this.name = streetDetails[2];
        this.timeToStreetEnd = Integer.parseInt(streetDetails[3]);
//        this.streetLight.state = false;
    }
}

