package models;

public class Intersection {
    int id;
    Street[] incomingStreets;

    public Intersection(int id, Street[] streets) {
        this.id = id;
        this.incomingStreets = streets;
    }
}
