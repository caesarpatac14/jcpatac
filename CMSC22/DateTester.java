/**
*
* Created by jcpatac on 9/16/16.
*
**/

public class DateTester {
	public static void main(String[] args) {
      Test constructor and toString()
      Date d1 = new Date(2016, 4, 6);
      System.out.println(d1);  // toString()
 
      // Test Setters and Getters
      d1.setYear(2012);
      d1.setMonth(2);
      d1.setDay(30);
      System.out.println(d1);  // run toString() to inspect the modified instance
      System.out.println("Year is: " + d1.getYear());
      System.out.println("Month is: " + d1.getMonth());
      System.out.println("Day is: " + d1.getDay());
 
      // Test setDate()
      d1.setDate(2988, 1, 2);
      System.out.println(d1);  // toString()


     Date d4 = new Date();
     d4.setMonth(2);
     d4.setDay(28);
     d4.setYear(1600);

     System.out.println(d4);
   }
}

/**
*
* There are two ways to write error-free programs; only the third one works. – Alan J. Perlis
*
**/
