package QuickSortPackage;

public class QuickSort {
	public static void main(String args[]){
		int[] test = {37,2,6,4,89,8,10,12,68,45};
		System.out.println("Initial Array: ");
		for(int i=0;i<test.length;i++)
			System.out.print(test[i] + " ");
		
		quickSortHelper(test, 0, test.length - 1);
		
		System.out.println("\n\nSorted Array: ");
		for(int i=0;i<test.length;i++)
			System.out.print(test[i] + " ");
	}
	
	static int partitionHelper(int arr[], int left, int right) {
	    int i = left, j = right;
	    int tmp;
	    int pivot = arr[(left + right) / 2];
	    
	    while(i <= j) {
	    	while(arr[i] < pivot)
	    		i++;
	        while(arr[j] > pivot)
	            j--;
	        if(i <= j) {
	            tmp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = tmp;
	            i++;
	            j--;
	        }
	    };
	      
	    return i;
	}

	static void quickSortHelper(int arr[], int left, int right) {
	    int index = partitionHelper(arr, left, right);
	    if(left < index - 1)
	    	quickSortHelper(arr, left, index - 1);
	    if(index < right)
	    	quickSortHelper(arr, index, right);
	}
}