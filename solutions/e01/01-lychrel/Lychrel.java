
import java.util.Scanner;
import java.util.*;

public class Lychrel {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Long num = sc.nextLong();

    lychrelSeq(num);
  }

  /*
  * Pre-condizioni: num is a lychrel number
  * Post-condizioni: print the lychrel seq from num
  */
  public static void lychrelSeq(long num){
    long reversed = reverseLong(num);
    
    while (!isPalindrome(num, reversed)){
      num = num + reversed;
      reversed = reverseLong(num);

      System.out.println(num);
    }
  }

  /**
  * Pre-condizioni: num1 and num2 are numbers
  * Post-condizioni: true if is palindrome else otherwise
  */
  public static boolean isPalindrome(long num1, long num2){
    if (num1 == num2) {
      return true;
    }

    return false;
  }

  /**
  * Pre-condizioni: num is a long number
  * Post-condizioni: return the reversed number
  */
  public static long reverseLong(long num){
    String numString = Long.toString(num);

    String endString = "";

    for (int j = numString.length() - 1; j >= 0; j--){
      
      endString += numString.charAt(j);
    }

    return Long.parseLong(endString);
  }
}
