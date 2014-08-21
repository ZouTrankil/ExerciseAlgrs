package nerver.more;

public class InsertionSort extends SortEverything {

	/* 
	 * O(n2)
	 */
	public void sort(Comparable[] arr) {
		if (arr == null || arr.length <= 1) 
			return;
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			Comparable tmp = arr[i];
			for (;j > 0 && tmp.compareTo(arr[j-1]) < 0; j--)
				arr[j] = arr[j-1];
			arr[j] = tmp;
		}
	}

}
