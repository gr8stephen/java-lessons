public class Forloops_odd {
    public static void main( String[] args){
        int [] oddNumbers = new int[5];
        int index = 0;
        int i;
        for(i=0; i<=10; i++){
            if(i==20) break ;
            if(i%2==1){
                oddNumbers[ index ] = i;
                index++;
                
                
            }
        }
        for( int j = oddNumbers.length - 1; j>= 0; j-- ){
            System.out.println(oddNumbers[j]);
        }
    }
    
}
