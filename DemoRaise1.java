public class DemoRaise1 {

        public static void main(String[] args) {
            
            System.out.println("Demonstrating some raises:");
            predictRaise(400.00,0.10);
            
    
        }
        public static void predictRaise( double moneyAmount, double percentRate ){
            double newAmount;
            newAmount = moneyAmount * (1+ percentRate);
            System.out.println( " with raise salary is "+newAmount);
        }
        
    }
    

