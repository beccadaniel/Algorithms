package models;

import java.util.ArrayList;

public class Result {
    public int intersectionId;
    public int streetAmount;
    public ArrayList<StreetDuration> list;

    public Result(int id, ArrayList<StreetDuration> list) {
        this.intersectionId = id;
        this.list = list;
        this.streetAmount = list.size();
    }

    public static class StreetDuration {
        public String name;
        public int lightDuration;

        public StreetDuration(String name, int duration) {
            this.name = name;
            this.lightDuration = duration;
        }
    }
}


