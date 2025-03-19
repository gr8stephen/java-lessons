public class Precedence {
    public static void main(String[] args) {
        int tickets = 4;
 int age = 40;
 char gender = 'F';
 if(tickets > 3 || age < 25 && gender == 'M')
  System.out.println("Do not insure");
 if((tickets > 3 || age < 25) && gender == 'M')
  System.out.println("Bad risk");
    }
}
