package models;

import java.util.Arrays;

public class Car {
//    String[] path;
    Street[] streets;
    int numberOfStreets;
    Street startStreet;
    int timeToDestination;

    public Car(Street[] streets) {
        this.numberOfStreets = streets.length;
//        path = new String[numberOfStreets];
//        path = Arrays.copyOfRange(carDetails, 1, numberOfStreets);
        startStreet = streets[0];
        this.streets = streets;
    }

    public int getTimeToDestination() {
        timeToDestination = 0;
        for (int i = 1; i < streets.length; i++) {
            timeToDestination += streets[i].timeToStreetEnd;
        }
        return timeToDestination;
    }

}
