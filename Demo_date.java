import java.util.*;
 public class Demo_date
 {
 public static void main(String[] args)
 {
 Date toDay = new Date();
 Date birthDay = new Date(82,6,14);
 System.out.println(toDay);
 System.out.print("Current month is ");
 System.out.println(toDay.getMonth());
 System.out.print("Current day is ");
 System.out.println(toDay.getDate());
 System.out.print("Current year is ");
 System.out.println(toDay.getYear());
 System.out.print("Birth month is ");
 System.out.println( birthDay.getMonth());
 System.out.print("Birth day is ");
 System.out.println(birthDay.getDate());
 System.out.print("Birth year is ");
 System.out.println(birthDay.getYear());
 }
 }