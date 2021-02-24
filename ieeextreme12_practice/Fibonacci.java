/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ieeextreme12_practice;

import java.util.Scanner;

/**
 *
 * @author folashade
 */
public class Fibonacci {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int t = input.nextInt();
        
        for(int i = 0; i < t; i++) {
            int fibNum = input.nextInt();
            
            /**
             * Calculate the remaining humans by getting fibonacci of (fibNum + 1) and then find mod 10 of it
             * Note that after the first 60 fibonacci terms, nth fibonacci term % 10 starts repeating after the 60th term
             * i.e fibonacci terms mod 10 is of period 60
             */
            System.out.println((fibonacci((fibNum + 1) % 60) % 10));
        }
    }
    
    /**
     * This method gets the (fib)th fibonacci term 
     * i.e if fib is 5 then the function gets the 5th fibonacci term
     * @param fib
     * @return 
     */
    
    public static long fibonacci(int fib) {
        double constTerm = 1/Math.sqrt(5);
        double additiveTerm = Math.pow(((1 + Math.sqrt(5))/2), fib);
        double subtractiveTerm = Math.pow(((1 - Math.sqrt(5))/2), fib);
        
        Double fibTerm = constTerm * (additiveTerm - subtractiveTerm);
        
        return fibTerm.longValue();
    }
}