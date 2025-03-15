import java.util.Scanner;
public class Frequency {
    public static void main( String[] args){
        Scanner scanner =new Scanner(System.in);
        int a[ ]={1,2,5,4,3,5,2,1,3,3,1,4,3,2,5,3,4,5,3,1};
        int awful=0;
        int good=0;
        int better =0;
        int best=0;
        int excellent=0;
        for ( int i=0 ;i < a.length ; i++){
            if (a[ i ]==1 ){
                awful= awful + 1;
            }
            else if ( a[i]==2){
                good = good+1 ;
            }
            else if (a[i]==3){
                better=better +1 ;
            }
            else if(a[i]==4){
                best = best+ 1;
            }
            else {
                 excellent = excellent+1;
                }



        }
        System.out.println(" awful is " + awful);
        System.out.println("good is " + good);
        System.out.println("better is " + better);
        System.out.println("best is " + best);
        System.out.println("excellent is " + excellent);
        
    }
}
