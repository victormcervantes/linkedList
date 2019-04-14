package collections.list.generics;

public class Queue <T extends Comparable<T>>
{  
   LinkedList<T> list;
   
   public Queue()
   {
      list = new LinkedList<T>();
   }
   public void enqueue(T data)
   {
      list.add(data);
   }
   public T dequeue()
   {
      return list.remove(0);
   }
   public boolean isEmpty()
   {
      if(list.size() == 0)
         return true;
      return false;
   }
   //used for testing
   public static void main(String[] args)
   {
      Queue<Integer> s = new Queue<>();
      System.out.println("Enqueuing: " );
      for( int i=0; i<5; i++ ) 
      {
         System.out.print(i + " ");
         s.enqueue(i);
      }
      System.out.println("\n---------------");
      System.out.println("Dequeuing: " );
      while( s.isEmpty() == false )
      {
         System.out.print( s.dequeue() + " ");
      }
     System.out.println( "\nOne more: " + s.dequeue());
   }

}
