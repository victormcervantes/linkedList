package collections.list.generics;

public class LinkedList<T extends Comparable<T>> implements List<T>
{
   Node<T> root;
   
   public void add(T val)
   {
      Node<T> temp = new Node<>(val);
      
      if( root == null )
      {
         root = temp;
      }
      else
      {
         Node<T> r = root;
         while( r.next != null )
         {
            r = r.next;
         }
         r.next = temp;         
      }
   
   }
   public int size()
   {
      int count = 0;
      Node<T> r = root;
      while( r != null )
      {
         count++;
         r = r.next;
      }
      return count;
   }
   public T remove(int idx) throws IndexOutOfBoundsException
   {
      if( idx >= size() || idx < 0 ) 
      {
         throw new IndexOutOfBoundsException(idx + " is out of bounds!");
      }
      T retVal;
      if( idx == 0 ) 
      {
         retVal = root.val;
         root = root.next;
      }
      else
      {
         Node<T> r = root;
         for( int i=0; i < idx-1; i++) 
         {
            r = r.next;
         }
         retVal = r.next.val;
         r.next = r.next.next;
      }
      return retVal;
   }
   public void add(int idx, T val) throws IndexOutOfBoundsException
   {
      if( idx > size() || idx < 0 ) 
      {
         throw new IndexOutOfBoundsException(idx + " is out of bounds!");
      }
      if( idx == 0 ) 
      {
         Node<T> temp = root;
         root = new Node<>(val);
         root.next = temp;
      }
      else
      {
         Node<T> r = root;
         for( int i=0; i < idx; i++) 
         {
            r = r.next;
         }
         Node <T> temp = r.next;
         r.next = new Node<>(val);
         r.next.next = temp;
      }
   }
   public void print()
   {
      Node<T> r = root;
      while(r != null)
      {
         System.out.print(r.val + " ");
         r = r.next;
      }
      System.out.println();
   }
   public void sort()
   {
      for (int i = 0; i < size(); i++)
      {
         Node<T> r = root;
         Node<T> r2 = r.next;
         while(r2 != null)
         {
            if(r.val.compareTo(r2.val) > 0)
            {
               T temp = r2.val;
               r2.val = r.val;
               r.val = temp;
            }
            r2 = r2.next;
            r = r.next;
         }
      }
   }
   public void clear()
   {
      root = null;
   }
   
   public boolean isFull()
   {
      return false;
   }
   
   public boolean isEmpty()
   {
      if(size() == 0)
         return true;
      else
         return false;
   }
   
   public void set(int idx, T val) throws IndexOutOfBoundsException
   {
      if( idx >= size() || idx < 0 ) 
      {
         throw new IndexOutOfBoundsException(idx + " is out of bounds!");
      }
      if( idx == 0 ) 
      {
        root.val = val;
      }
      else
      {
         Node<T> r = root;
         for( int i = 0; i < idx; i++) 
         {
            r = r.next;
         }
         r.val = val;
      }
   }
   public T get(int idx)
   {
      if( idx >= size() || idx < 0 ) 
      {
         throw new IndexOutOfBoundsException(idx + " is out of bounds!");
      }
      Node<T> r = root;
      for( int i=0; i < idx; i++) 
      {
         r = r.next;
      }
      return r.val;
   }
   public int indexOf(T val)
   {
      for(int i = 0; i < size(); i++)
      {
         if(get(i).equals(val))
            return i;
      }
      return -1;
   }
      
   public int lastIndexOf(T val)
   {
      for(int i = size() - 1; i >= 0; i--)
      {
         if(get(i).equals(val))
            return i;
      }
      return -1;
   }
   public boolean contains(T val)
   {
      Node<T> r = root;
      for(int i = 0; i < size(); i++)
      {
         if(get(i).equals(val))
            return true;
      }
      return false;
   }
   @Override 
   public String toString()
   {
      String retVal = "";
      Node<T> r = root;
      while(r != null)
      {
         retVal = retVal  + r.val;
         r = r.next;
         if (r != null)
             retVal = retVal + " ";
      }
      return retVal;
   }
}