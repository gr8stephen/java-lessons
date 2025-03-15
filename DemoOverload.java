public class DemoOverload {
    public static void main(String[] args) {
        int month = 6 , day =24 , year = 2003 ;
        overloadDate(month);
        overloadDate(month,day);
        overloadDate(month,day,year);
    }
    public static void overloadDate( int mm){
        System.out.println("Event date " + mm + "/1/2003");
    }
    public static void overloadDate( int mm, int dd ){
        System.out.println("Event date" + mm + "/" + dd + "/2003");
    }
    public static void overloadDate(int mm, int dd , int yy){
        System.out.println("Event date " + mm + "/" + dd + "/" + yy );
    }
}
