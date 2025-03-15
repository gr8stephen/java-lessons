import java.util.*;
public class Class_exceptions {
    public static void main (String[] args){
        int marr[] = new int [5];
        int a,b ;
        Scanner sc = new Scanner ( System.in);
        for (int i=0; i<marr.length; i++){
            System.out.println("Enter index and value :");
            a=sc.nextInt();
            b=sc.nextInt();
            try
            {
                marr[a] = b;

            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.print("\nPlease enter a valid input:");
                i--;

            }
            catch(InputMismatchExpcetion e)
            {
                System.out.print("\nPlease enter a valid input:");
                i--;

            }
    
}
for(int i=0; i<marr.length; i++){
    System.out.print("\n\nValue @ index\t"+i+ "\t=\t"+marr[i]+"\n\n");

}
}
}
 