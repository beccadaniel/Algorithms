package rankandfile;

import java.io.*;
import java.util.*;

public class RankAndFile1A16 {

    public static void main(String[] args) {
        File file = new File("codejam/rankandfile/output/rankandfile.txt");
        BufferedReader reader;
        try {
            FileWriter fw = new FileWriter(file);
            Scanner sc = new Scanner(new File("codejam/rankandfile/input/rank_and_file_large.in"));

            while (sc.hasNextLine()) {
                int t = sc.nextInt();
                for (int i = 0; i < t; i++) {
                    int n = sc.nextInt();
                    HashMap<Integer, Integer> map = new HashMap<>();
                    for (int j = 0; j < ((2 * n - 1) * n); j++) {
                        int currentValue = sc.nextInt();
                        if (map.containsKey(currentValue)) {
                            map.put(currentValue, map.get(currentValue) + 1);
                        } else {
                            map.put(currentValue, 1);
                        }
                    }
                    SortedSet<Integer> set = new TreeSet<>();

                    for (int key: map.keySet()) {
                        if (map.get(key) % 2 != 0) {
                            set.add(key);
                        }
                    }
                    fw.write("Case #" + (i + 1) + ": ");
                    for (int value : set) {
                        fw.write(value + " ");
                    }
                    fw.write("\n");
                }
                sc.nextLine();
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
