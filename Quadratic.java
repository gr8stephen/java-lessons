
import java.util.Scanner;

public class Quadratic {
    public static void main( String[] arg){
        System.out.println(" Enter the three coefficients");
        Scanner sc = new Scanner( System.in );
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double root1 = ( -b + Math.sqrt ( b*b - 4*a*c ) ) /(2*a);
        double root2 = ( -b -Math.sqrt( b*b - 4*a*c) )/(2*a);
        System.out.println("The roots are:"+ root1);
        System.out.println("and:" + root2);
        System.out.println("The equation is:");
        System.out.println(" +a.x^2 + b.x + c");

        

        

    }
    
}
