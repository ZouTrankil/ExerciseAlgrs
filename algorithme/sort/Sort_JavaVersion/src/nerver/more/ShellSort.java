package nerver.more;

public class ShellSort extends SortEverything {

	/* 
	 * maybe better than insertionSort
	 * but the average consumption depends on the preInsert array and real array's feature  
	 */
	public void sort(Comparable[] arr) {
		if (arr == null || arr.length <= 1) 
			return;
		int size = arr.length;
		int h = 1;
		while (h < size / 3)
			h = 3 * h + 1; // 1, 4, 13 ............
		
		while (h >= 1) {
			for (int k = h; k < size; k += h) {
				int index = k;
				Comparable tmp = arr[k];
				while (index - h >= 0 && tmp.compareTo(arr[index-h]) < 0) {
					arr[index] = arr[index - h];
					index -= h;
				}
				arr[index] = tmp; 
			}
			
			h /= 3;
		}
	}

}
