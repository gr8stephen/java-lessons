
public class UsersInitials {
    public static void main(String[] args) throws Exception{
        char firstInit, middleInit, lastInit ;
        System.out.println("Please enter your three initials.");
        System.out.println("Do not use periods or spaces between initials.");
        System.out.println("press enter when you are done ");
        firstInit = (char)System.in.read();
        middleInit =(char) System.in.read();
        lastInit = (char) System.in.read();
        System.out.println("Your initials are : " + firstInit + middleInit + lastInit);
        


    }
    
}
