package nerver.more;

import java.util.Random;

public abstract class SortEverything {

	public abstract void sort(Comparable[] arr);

	/** common method */
	
	public static void printAllElement(Comparable[] arr) { //print the array
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " , ");
		}
		System.out.println("]");
	}
	
	public static Integer[] createTheDataSample(int size, int range) { //create the randomized data
		if (size <= 0 || range <= 0)
			throw new IllegalArgumentException();
		
		Random r = new Random();
		Integer[] arr = new Integer[size];
		for (int i = 0; i < size; i++)
			arr[i] = new Integer(r.nextInt(range));
		for (int k = size; k > 1; k--)
			swap (arr, k - 1, r.nextInt(k));
		//return the sample data!
		return arr;
	}
	
	public static void swap(Comparable[] arr, int i, int j) {
		if (i < 0 || i >= arr.length || j < 0 || j >= arr.length)
			throw new IllegalArgumentException();
		
		Comparable tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
