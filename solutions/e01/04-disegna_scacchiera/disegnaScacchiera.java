import java.util.Scanner;

public class disegnaScacchiera{
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();

        printScack(num);
    }

    public static void printScack(int num){

        // 8 row repeated x n times
        for (int i = 0; i < 8; i++){

            for (int h = 0; h < num; h++){

                printRow(num, i);

            }
        }

    }

    public static void printRow(int num, int index){
        String c = "";

        if (index % 2 != 0){
            c = "#";
        }else{
            c = "-";
        }

        String res = "";

        // 8 column x n times
        for(int j = 0; j < 8; j++){

            for (int i = 0; i < num; i++){
                res += c;
            }

            //  IGNORANTISSIMO PENSO
            if (c == "#"){
                c = "-";
            }else{
                c = "#";
            }
        }

        System.out.println(res);
    } 

}
