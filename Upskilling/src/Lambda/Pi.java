package Lambda;

import java.lang.FunctionalInterface;

@FunctionalInterface
interface MyInterface1{

 double getPiValue();
}

public class Pi {

 public static void main( String[] args ) {

 MyInterface1 ref;
 
 ref = () -> 3.1415;
 
 System.out.println("Value of Pi = " + ref.getPiValue());
 } 
}