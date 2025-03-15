import java.util.Scanner;
public class Addition_New {
    public static void main(String[] args) {
        Scanner input = new Scanner( System.in);
        int number1;
        int number2;
        int sum;
        System.out.println(" please enter first integer");
        number1 = input.nextInt();
        System.out.println("please enter second integer");
        number2 = input.nextInt();
        sum =number1 + number2 ;
        System.out.println("sum = " + sum ); 

    }
}
