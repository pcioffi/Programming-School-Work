package Test_Review;
import java.util.Scanner;

public class Test_1 {
	public static void main(String[] args) {
	       int[] alpha = new int[10];
		      initialize(alpha);
		      print(alpha);
	    }
	    public static void initialize(int[] list)
	    {
		        int count;
		        for (count = 0; count < list.length / 2; count++)
			      list[count] = count * count;
		      for (count = list.length / 2; count < list.length; count++)
			       list[count] = 3 * count;
	    }

	    public static void print(int[] list)
	    {
	            	int count;
		 for (count = 0; count < list.length; count++)
		      { 
			               System.out.print(list[count] + " ");
			                if ((count + 1) % 10 == 0)
				          System.out.println();
		      }
		                  System.out.println();
	    }
}
