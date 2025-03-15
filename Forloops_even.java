public class Forloops_even {
    public static void main( String[] args){
        int [] evenNumbers = new int[5];
        int index = 0;
        int i;
        for(i=0; i<=10; i++){
            if(i==10) break ;
            if(i%2==0){
                evenNumbers[ index ] = i;
                index++;
                
                
            }
        }
        for( int j = evenNumbers.length -1; j>= 0; j-- ){
            System.out.println(evenNumbers[j]);
        }
    }
    
}


    

