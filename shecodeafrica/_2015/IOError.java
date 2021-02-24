package shecodeafrica._2015;

import java.io.*;

public class IOError {

    private static String filename = "shecodeafrica/_2015/input/A-small-practice.in";
    private static final String output = "shecodeafrica/_2015/output/result.txt";

    public static void main(String[] args) {
        //System.out.println(breakToBytes("OIOOIOOIOIIOOIIOOOIOOOOOOIIOIOOIOIIIOIOOOOIOOOOOOIIOOOIOOIIOOIOIOOIOOOOOOIIIOOIIOIIOIIIIOOIOIIOOOOIOOOOOOIIOIOOIOIIOOIIOOOIOOOOOOIOOIOOIOOIOOOOOOIIOIOOOOIIOOOOIOIIIOIIOOIIOOIOIOOIOOOOOOIIOOOIOOIIOOIOIOIIOOIOIOIIOIIIOOOIOOOOOOIIOIIOIOIIOIOOIOIIIOOIIOIIOIIOOOIIOOIOIOIIOOIOOOOIOOOOOOIIOOOIOOIIIIOOIOOIOOOOOOIIIOOIIOIIIOIOIOIIOOOIIOIIOIOOOOOIOOOOOOIIOOIOIOIIIOOIOOIIIOOIOOIIOIIIIOIIIOOIOOOIOOOOOOIIIOIOOOIIOIIIIOOIOOOOOOIIOIOOIOIIOIIIOOIIOOIIOOIIOIIOOOIIOIOOIOIIOOOIIOIIIOIOOOOIOOOOOOIIIOOOOOIIOOOOIOIIOIOOIOIIOIIIOOOIOOOOOOIIOIIIIOIIOIIIOOOIOOOOOOIIOIOOOOIIOOIOIOIIIOOIOOOIOIIOOOOIOOOOOOIIIIOOIOIIOIIIIOIIIOIOIOIIIOOIOOOIOOOOOOIIIOOIOOIIOOIOIOIIIOOIIOIIOOIOIOIIOIIIOOIIIOIOOOIIOIIOIOIIOOIOIOIIOIIIOOIIIOIOOOOIOOOOOOIIOIOOOOIIOOOOIOIIIOOIIOOIOOOOOOIIOIIIOOIIOIIIIOIIIOIOOOOIOOOOOOIIOOOIOOIIOOIOIOIIOOIOIOIIOIIIOOOIOOOOOOIIIOIOIOIIOIIIOOIIIOOIOOIIOOIOIOIIOOOOIOIIIOOIIOIIOIIIIOIIOIIIOOIIOOOOIOIIOOOIOOIIOIIOOOIIOOIOIOOIOIIIO", 115));



        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));

            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                bw.write("Case #" + (i+1) + ": " + breakToBytes(br.readLine(), n) + "\n");
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    // convert OIs to 01s and from binary equivalent to decimal
    private static int getDecimal(String iobyte) {
        iobyte = iobyte.replace('O', '0');
        iobyte = iobyte.replace('I', '1');
        //convert to decimal
        int index = 0;
        int decimal = 0;
        for(int j = iobyte.length()-1; j >=0; j--) {
            decimal =(int) (Math.pow(2 , index) * Character.getNumericValue(iobyte.charAt(j))) + decimal;
            index++;
        }
        return decimal;
    }

    // takes a string breaks into 8bits and converts to decimal
    private static String breakToBytes(String longString, int n) {
        int start = 0;
        int end = 8;
        String ans = "";
        for(int i = 0; i < n; i++) {
            int decimal = getDecimal(longString.substring(start,end));
            start = end;
            end = end + 8;
            //TODO convert the decimal value to character
            ans = ans + getChar(decimal);
        }
        return ans.trim();
    }

    // this method converts a decimal value to its ascii character equivalent
    private static char getChar(int decimal) {
        return (char)decimal;
    }

    /*Problem
    Our computers are so excited about the upcoming Google I/O that they've started storing their ones as capital letter Is and their zeroes as capital letter Os! For example, the character A, which is 65 in ASCII, would normally be stored as the byte 01000001, but our computers are storing it as OIOOOOOI.

    Given a string of 8-character "bytes" consisting of Is and Os, can you translate it using ASCII? Every "byte" is guaranteed to translate to a printable character (a decimal value between 32 and 126, inclusive). Note that one of these characters (the one with decimal value 32) is a space. No translated message will begin or end with a space, but there may be internal space characters.*/
}