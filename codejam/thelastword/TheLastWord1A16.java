package thelastword;

import java.io.*;

public class TheLastWord1A16 {
    public static void main(String[] args) throws IOException {
        File file = new File("codejam/thelastword/output/thelastword.txt");
        FileWriter fw = new FileWriter(file);

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("codejam/thelastword/input/last_word_practice_large.in"));
            String line = reader.readLine();
            int count = 0;
            while(line != null) {
                if (count > 0) {
                    fw.write("Case #" + (count) + ": " + getLastWord(line));
                    fw.write("\n");
                }
                count++;
                line = reader.readLine();
            }
            fw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getLastWord(String s) {
        StringBuilder builtString = new StringBuilder();
        builtString.append(s.charAt(0));
        int baseChar = s.charAt(0);
        for (int j = 1; j < s.length(); j++) {
            int currentChar = s.charAt(j);
            if (currentChar >= baseChar) {
                builtString.insert(0, s.charAt(j));
                baseChar = s.charAt(j);
            } else {
                builtString.append(s.charAt(j));
            }
        }
        return builtString.toString();
    }

    public static void writeWithFileWriter(String data) {
        File file = new File("codejam/thelastword/input/thelastword.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
