import java.util.Scanner;

public class disegnaV{

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int num = input.nextInt();

        printaV(num);
    }

    public static void printaV(int num){
        for(int i = 0; i < num; i++){
            if (num-1 == i){
                System.out.println(printaSpazi(i) + "*");
                continue;
            }

            String str = printaSpazi(i) + "*" + printaSpazi(((num-i)*2)-2) + "*";
            System.out.println(str);
        }
    }

    public static String printaSpazi(int num){
        String res = "";

        for(int i = 0; i < num; i++){
            res += " ";
        }

        return res;
    }


}

