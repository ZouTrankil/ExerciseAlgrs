package nerver.more;

public class MergeSort extends SortEverything {
	Comparable[] aux = null;
	public void sort(Comparable[] arr) {
		if (arr.length <= 1) return;
		aux = new Comparable[arr.length];
		mergeSort(arr, 0, arr.length - 1);
	}
	
	private void mergeSort(Comparable[] arr, int lo, int hi) {
		if (lo >= hi) return;
		int mid = lo + (hi - lo) / 2;
		mergeSort(arr, lo, mid);
		mergeSort(arr, mid + 1, hi);
		merge(arr, lo, mid, hi, aux);
	}
	
	private void merge(Comparable[] arr, int lo, int mid, int hi, Comparable[] aux) {
		int i = lo;
		int j = mid + 1;
		
		for (int k = lo; k <= hi; k++) 
			aux[k] = arr[k];
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) arr[k] = aux[j++];
			else if (j > hi) arr[k] = aux[i++];
			else if (aux[i].compareTo(aux[j]) < 0) arr[k] = aux[i++];
			else arr[k] = aux[j++];
		}
	}
}
