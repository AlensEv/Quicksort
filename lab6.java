package lab6sign;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//alens evra lab6
/*This  program  reads 
integers  from  an  input  file  specified  on  the  command  line.  The  imported  integers  are 
stored in an internal int array. You can specify the array size to be 5000. In other words, 
we assume the input data file can have at most 5000 integers. After importing the integers 
from the data file, main() calls the quick sort method and then prints the result */
public class lab6 {

	public static void main(String[] args) throws FileNotFoundException {
		int[] userArray = new int[5000];
		File file = new File("/Users/alense/Desktop/test14.txt"); // takes input from system file
		Scanner userFile = new Scanner(file);
		int index = 0;

		while (userFile.hasNextInt()) {
			userArray[index++] = (int) userFile.nextDouble();
		}

		userFile.close();
		// closes user's file
		int smallNum = 0;
		int highNum = userArray.length - 1;

		quickSort(userArray, smallNum, highNum);
		System.out.println("Quick Sort Result is: ");// sort will be from small to large

		int count = 0;
		for (int c : userArray) {
			if (c != 0) {
				System.out.println(c);
				count++;
			}
		}
		System.out.println("The amount of items sorted is " + count);
	}

	public static void quickSort(int[] arr, int smallNum, int highNum) {
		if (arr == null || arr.length == 0 || (smallNum >= highNum))
			return;

		// assigns pivot
		int mid = smallNum + (highNum - smallNum) / 2;
		int pivot = arr[mid];

		int i = smallNum, j = highNum;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}

		if (smallNum < j)
			quickSort(arr, smallNum, j);

		if (highNum > i)
			quickSort(arr, i, highNum);
	}
}
