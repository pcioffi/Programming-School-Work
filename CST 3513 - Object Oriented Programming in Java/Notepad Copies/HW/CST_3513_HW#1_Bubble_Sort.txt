public class BubbleSort {
	public static void main(String args[]){
		int[] bubbleArray = {95, 22, 14, 10, 9, 5, 2};
		
		printList(bubbleArray);
		bubbleSort(bubbleArray);

	}
	public static void printList(int[] x){
		for(int i = 0; i < x.length; i++){
			System.out.print(x[i] + " ");
		}
		
		System.out.println();
	}
	public static void bubbleSort(int[] x){	
		for(int i = 0;i < (x.length - 1); i++){
			sortList(x);
			printList(x);
		}

	}
	public static void sortList(int[] x){
		for(int i = 1; i < x.length; i++){
			int temp = 0;
			if(x[i - 1] > x[i]){
				temp = x[i - 1];
				x[i - 1] = x[i];
				x[i] = temp;
			}
		}
	}
}
