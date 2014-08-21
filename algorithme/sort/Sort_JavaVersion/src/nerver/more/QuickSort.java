package nerver.more;

public class QuickSort extends SortEverything {

	public void sort(Comparable[] arr) {
		if (arr == null || arr.length <= 1) return;
		quickSort(arr, 0, arr.length - 1);
	}

	private void quickSort(Comparable[] arr, int lo, int hi) {
		if (lo >= hi) return;
		int p = partition(arr, lo, hi);
		quickSort(arr, lo, p - 1);
		quickSort(arr, p + 1, hi);
	}

	private int partition(Comparable[] arr, int lo, int hi) {
		Comparable tmp = arr[lo];
		int i = lo, j = hi + 1;
		while (true) {
			while (tmp.compareTo(arr[--j]) < 0) if (j == lo) break;
			while (tmp.compareTo(arr[++i]) > 0) if (i == hi) break;;
			if (i >= j) break;
			SortEverything.swap(arr, i, j);
		}
		SortEverything.swap(arr, j, lo);
		return j;
	}

}
