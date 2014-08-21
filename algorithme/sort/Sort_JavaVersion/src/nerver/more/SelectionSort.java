package nerver.more;

public class SelectionSort extends SortEverything {

	public void sort(Comparable[] arr) {
		for (int i = 0; i < arr.length; i++) {
			Comparable tmp = arr[i];
			int j = i + 1;
			int min = i;
			for (; j < arr.length; j++) {
				if (arr[j].compareTo(tmp) < 0) {
					tmp = arr[j];
					min = j;
				}
			}
			SortEverything.swap(arr, i, min);
		}
	}

}
