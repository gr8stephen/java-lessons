import java.util.Scanner;
public class GradingSystem1{ 
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter exam score:");
        int examScore=scanner.nextInt();
        System.out.println("Ener assesment score:");
        int assessmentScore=scanner.nextInt();
        System.out.println("Enter amount of fees paid ");
        int fees=scanner.nextInt();
        int totalScore=0  ;
        totalScore=examScore+assessmentScore ;
        if( totalScore>=40 && fees==100){
            System.out.println(" you have passed and you will be issued a certificate");
        }
        else if ( totalScore>=40 && fees<100 ){
            System.out.println(" you have passed");
                  
        }
        else if ( totalScore< 40 && fees==100){
            System.out.println("you have failed");
        }
        else{ 
            System.out.println("you have failed and you will be repeated");
        }
        


        
    }
}
