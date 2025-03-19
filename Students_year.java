import java.util.Scanner;
public class Students_year{
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int year ;
        System.out.println("enter your class year ");
        year = scanner.nextInt();
        switch(year){
            case 1 :
            System.out.println("Freshmen");
            break;
            case 2:
            System.out.println(" sophomore");
            break;
            case 3:
            System.out.println("Junior");
            break ;
            case 4:
            System.out.println("Senior");
            break ;
            default:
            System.out.println("Invalid year");
        }
        scanner.close();

    }
}