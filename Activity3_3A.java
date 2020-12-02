package javaActivity_3;
import java.util.LinkedList;
import java.util.Queue;

public class Activity3_3A {
    public static void main(String[] args) {
    	
		//Create a Queue named q.
    	  Queue<Integer> q = new LinkedList<>();
		
    	  //Add first 5 natural numbers to it and print the Queue.
    	   for (int i=0;i<5;i++) {
               q.add(i);
           }

    	   //Display contents of the queue. 
           System.out.println("Elements in queue: " + q);
           
		//Remove a number in the Queue using the remove() method.
           //To remove the head of queue.
           int removeEle = q.remove();
           System.out.println("removed element: " + removeEle);
           
		//Peek() at the first number in the Queue after removal.
         //To view the head of queue
           int headEle = q.peek();
           System.out.println("head of queue: " + headEle);
           
		//Print the size of the Queue using the size() method. Print the updated Queue.
           
           int size = q.size();
           System.out.println("Size of queue: " + size);

	}

}



     
