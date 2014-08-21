package nerver.more;

public class BubbleSort extends SortEverything {

	public void sort(Comparable[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j].compareTo(arr[j-1]) < 0)
					SortEverything.swap(arr, j, j-1);
			}
		}
	}
}
