package hackerrank;

/*
 * Given a base-10 integer, n, convert it to binary (base-2).
 * Then find and print the base-10 integer denoting the maximum 
 * number of consecutive 1's in n's binary representation.
 */

import java.io.*;
import java.util.*;

public class BinaryNumbers{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        Stack<Integer> binary = new Stack();
        
        while(n > 0){
            int rem = n%2;
            binary.push(rem);
            
            n = n/2;
        }
        
        int count=0;
        int newCount = 0;
        while(!binary.isEmpty()){
            int temp = binary.pop();
            if(temp == 1){
                count++;
            }
            if(count > newCount)
                newCount = count;
                
            if(temp == 0)
                count = 0;
            
        }
        System.out.println(newCount);
    }
}
