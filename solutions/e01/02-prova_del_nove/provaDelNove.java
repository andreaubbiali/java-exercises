
/**
Error with number with more than one digits (50/100/...)
with 3/4/5/6 it works
 */

import java.util.Scanner;

public class provaDelNove {
    
    public static void main(String[] args){
        
        Scanner s = new Scanner(System.in);

        calc(s.nextInt());
    }

    /**
    pre-condition: num is an integer > 0
    post-condition: printed numbers that make the 9 rules true even if wrong
     */
    public static void calc(int num){

        for (int a = 0; a < num; a++){
            for (int b = 0; b < num; b++){
                for (int c = 0; c < num; c++){
                    
                    if (a*b == c){
                        continue;
                    }

                    if (isRightFor9Prove(a, b, c)){
                        System.out.println(a + " " + b + " " + c);
                    }

                }
            }
        }

    }

    /**
    pre-condition: a,b,c three positive numbers
    post-confition: true if the three number make true the 9 rule, false otherwise
     */
    public static boolean isRightFor9Prove(int a, int b, int c){

        int sumA = sum(a);
        int sumB = sum(b);
        
        int finalOperandSum = sum(sumA*sumB);
        
        return finalOperandSum == c;
    }

    /**
    pre-condition:num positive
    post-condition: return the sum of the digits of num
     */
    public static int sum(int num){
        String s = Integer.toString(num);
        
        int sum = num;

        while (!(s.length() == 1)){
            sum = 0;
            for (int j = 0; j < s.length(); j++){
                sum += Integer.parseInt(s.substring(j, j+1));
            }

            s = Integer.toString(sum);
        }


        return sum;
    }
}
