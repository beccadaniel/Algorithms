import models.Car;
import models.Intersection;
import models.Result;
import models.Street;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    HashMap<String, Street> streetMap;
    Car[] cars;
    int simulationDuration;
    ArrayList<Result> outputList = new ArrayList<>();
    ArrayList<Intersection> intersections;
    int numberOfIntersections;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.parseInput("/Users/folashadedaniel/IdeaProjects/hashcode/src/input/f.txt");
        solution.parseOutput("/Users/folashadedaniel/IdeaProjects/hashcode/src/output/f.txt");

    }

    public void parseInput(String filename) {
        int bufferSize = 8 * 1024;

        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(filename), bufferSize);

            String firstLine = br.readLine();
            String[] arr = firstLine.split(" ");

            simulationDuration = Integer.parseInt(arr[0]);
            numberOfIntersections = Integer.parseInt(arr[1]);
            int numberOfStreets = Integer.parseInt(arr[2]);
            int numberOfCars = Integer.parseInt(arr[3]);
            int bonusPoint = Integer.parseInt(arr[4]);

            streetMap = new HashMap<>();

            cars = new Car[numberOfCars];

            HashMap<Integer, ArrayList<String>>  intersectionMap = new HashMap<>();

            for (int i = 0; i < numberOfStreets; i++) {
                String[] streetDetails = br.readLine().split(" ");
                streetMap.put(streetDetails[2], new Street(streetDetails));

                int key = Integer.parseInt(streetDetails[1]);
                ArrayList<String> street = intersectionMap.getOrDefault(key, new ArrayList<>());
                street.add(streetDetails[2]);
                intersectionMap.put(key, street);
            }

            for (int v = 0; v < numberOfCars; v++) {
                String[] carDetails = br.readLine().split(" ");
                Street[] carStreets = new Street[Integer.parseInt(carDetails[0])];
                for(int j = 0; j < carDetails.length - 1; j++) {
                    carStreets[j] = streetMap.get(carDetails[j+1]);
                }
                cars[v] = new Car(carStreets);
            }

            getResult(intersectionMap);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void getResult(HashMap<Integer, ArrayList<String>> rawResult) {
        Result current;

        for (Map.Entry element: rawResult.entrySet()) {
            int key = (Integer) element.getKey();
            ArrayList<String> streets = (ArrayList<String>)element.getValue();
            ArrayList<Result.StreetDuration> durations = getStreetDurationForResult(streets);

            current = new Result(key, durations);
            outputList.add(current);
        }



//        for (Map.Entry mapElement : hm.entrySet()) {
//            String key = (String)mapElement.getKey();
//
//            // Add some bonus marks
//            // to all the students and print it
//            int value = ((int)mapElement.getValue() + 10);
//
//            System.out.println(key + " : " + value);
//        }
    }

    private ArrayList<Result.StreetDuration> getStreetDurationForResult(ArrayList<String> data) {
        ArrayList<Result.StreetDuration> result = new ArrayList<>();
        for (String val : data) {
            Result.StreetDuration ans = new Result.StreetDuration(val, 1);
            result.add(ans);
        }
        return result;
    }

    public void parseOutput(String filename) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(filename, "UTF-8");
            writer.println(outputList.size());
            for (int j = 0; j < outputList.size(); j++) {
                writer.println(outputList.get(j).intersectionId);
                writer.println(outputList.get(j).streetAmount);
                for (int i = 0; i < outputList.get(j).list.size(); i++) {
                    Result.StreetDuration result = outputList.get(j).list.get(i);
                    writer.print(result.name + " ");
                    writer.print(result.lightDuration);
                    writer.println();
                }
            }

            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
