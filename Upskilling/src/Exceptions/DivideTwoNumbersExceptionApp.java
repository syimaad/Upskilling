package Exceptions;

public class DivideTwoNumbersExceptionApp {

    public static void main(String[] args) {
        System.out.println(divide(30, 2));
        System.out.println(divide(15, 0));
        System.out.println("The job is finished!");
    }

    private static int divide(int dividend, int divisor){

        try {
           
            return dividend / divisor;
        } catch (NullPointerException exception) {
            System.err.println("NullPointerException is thrown");
            return 0;
//        finally {
//            System.out.println("Hey, I'm a very good tool to close files and database connections.");
 }

    }
}