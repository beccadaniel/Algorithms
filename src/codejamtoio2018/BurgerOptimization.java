package codejamtoio2018;

import shecodeafrica._2016.utils.Constants;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class BurgerOptimization {

    private static String filename = Constants.FILENAME;
    private static final String output = Constants.OUTFILE;

    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader(filename)));
            bw = new BufferedWriter(new FileWriter(output));

            int t = in.nextInt();
            for (int i=0; i<t; i++) {
                int sum = 0;
                int k = in.nextInt();
                int[] vals = new int[k];
                for(int j=0; j<k; j++) {
                    vals[j] = in.nextInt();
                }

                Arrays.sort(vals);

                if (k%2==0) {
                    int inc = 0;
                    for (int r=0; r<vals.length; r+=2) {

                        vals[r] = (vals[r] - inc) *(vals[r] - inc);
                        vals[r+1] = (vals[r+1] - inc) *(vals[r+1] - inc);

                        inc++;
                    }
                }
                else {
                    int inc = 0;
                    for(int v =0; v<=vals.length; v+=2) {
                        vals[v] = (vals[v] - inc) *(vals[v] - inc);
                        if((v+1) < vals.length) {
                            vals[v+1] = (vals[v+1] - inc) *(vals[v+1] - inc);
                        }
                        inc++;
                    }
                }

                for(int s =0; s<vals.length; s++) {
                    sum += vals[s];
                }
                bw.write("Case #"+ (i+1) + ": " + sum);
                bw.write("\n");
            }

        }
        catch (Exception ex) {

        }finally {
            try {
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
