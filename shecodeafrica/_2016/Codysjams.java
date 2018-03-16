package shecodeafrica._2016;

import shecodeafrica._2016.utils.Constants;

import java.io.*;
import java.util.ArrayList;

public class Codysjams {

    private static String filename = Constants.FILENAME;
    private static final String output = Constants.OUTFILE;

    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            bw = new BufferedWriter(new FileWriter(output));
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                ArrayList<Long> price = new ArrayList<>();
                String[] arr = br.readLine().split(" ");
                for (int j = 0; j < arr.length; j++) {
                    price.add(Long.valueOf(arr[j]));
                }
                bw.write("Case #"+ (i+1) + ": " + getPrice(price, n));
                bw.write("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    static String getPrice(ArrayList<Long> prices, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            long value = prices.get(0);
            int index = prices.indexOf((4 * value) / 3);
            sb.append(value);
            sb.append(" ");
            prices.remove(index);
            prices.remove(0);
        }
        return sb.toString();
    }
}
