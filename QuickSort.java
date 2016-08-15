import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	public int[] array;
	public Random rng;
	
	public QuickSort(int[] array) {
		this.array = array;
		rng = new Random();
	}
	
	// right is an exclusive index
	public void sort(int left, int right) {
		if (right - left <= 1);
		else {
			int pivot = left + rng.nextInt(right-left);
			int i = pivot - 1;
			int j = pivot + 1;
			while (i >= left) {
				if (array[i] > array[pivot]) {
					int temp = array[i];
					array[i] = array[pivot];
					array[pivot] = temp;
					if (i < pivot - 1) {
						temp = array[pivot-1];
						array[pivot-1] = array[i];
						array[i] = temp;
					}
					pivot--;
				}
				i--;
			}
			while (j < right) {
				if (array[j] < array[pivot]) {
					int temp = array[j];
					array[j] = array[pivot];
					array[pivot] = temp;
					if (j > pivot + 1) {
						temp = array[pivot+1];
						array[pivot+1] = array[j];
						array[j] = temp;
					}
					pivot++;
				}
				j++;
			}
			sort(left, pivot);
			sort(pivot, right);
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[100];
		for (int i = 0; i < 99; i++) array[i] = (int) (Math.random() * 100);
		System.out.println(Arrays.toString(array));
		QuickSort qs = new QuickSort(array);
		qs.sort(0, array.length);
		System.out.println(Arrays.toString(qs.array));
		for (int i = 1; i < 99; i++) {
			if (qs.array[i] < qs.array[i-1]) {
				System.out.println("false");
				break;
			}
		}
	}
}
