package LinkedLists;

import java.util.LinkedList;

public class LinkedListApp {

    public static void main(String[] args) {

        LinkedList<String> letters = new LinkedList<>();
        
      letters.add("x");
      letters.add("y");
      letters.add("z");
        
        if (!letters.isEmpty()) {
            System.out.println("The first element of the list: " + letters.getFirst());
        }

        if (!letters.isEmpty() && letters.peekFirst() != null) {
            System.out.println("The first element of the list: " + letters.peekFirst().toUpperCase());
        }

        letters.add("A");
        letters.addFirst("B");
        letters.push("C");
        letters.offer("D");


        System.out.println(letters);

        System.out.println("first element on my list: " + letters.pollFirst());
        System.out.println("last element on my list: " + letters.pollLast());

        System.out.println(letters);

    }
}