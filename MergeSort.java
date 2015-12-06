/* 合併排序                 */
/* File name MergeSort.java */
/* Version 1.0, 5-25-2008   */
 
import java.io.*;
import java.util.Scanner;

class MergeSort 
{
	static int[] data1 = new int[10];
	static int[] data2 = new int[10];
	static int[] data3 = new int[20];
 
	public static void merge_sort()
	{
		Scanner keyboard = new Scanner(System.in);
		String st="";
		int size1=0, size2=0, i=0, j=0;
        
		System.out.print("\nPlease enter data 1 to sort ( enter 0 when end ):\n");
		do {
			System.out.printf("#%d number : ", ++i);
 			data1[size1] = keyboard.nextInt();
		} while (data1[size1++] != 0);
		System.out.print("\nPlease enter data 2 to sort ( enter 0 when end ):\n");
		
		do {
			System.out.printf("#%d number : ", ++j);
 			data2[size2] = keyboard.nextInt();       
		} while (data2[size2++] != 0);
		
		// 先使用選擇排序將兩數列排序，再作合併
		select_sort(data1, --size1);
		select_sort(data2, --size2);
		
		for (i = 0; i < 60; i++) 
			System.out.print("-");
		System.out.print("\nData 1 : ");
		for (i = 0; i < size1; i++)
			System.out.print(data1[i] + "  ");
		System.out.print("\nData 2 : ");
		for (i = 0; i < size2; i++)
			System.out.print(data2[i] + "  ");
		System.out.print("\n");
		for (i = 0; i < 60; i++) 
			System.out.print("-");
		System.out.print("\n");
		sorting(size1, size2);
		for (i = 0; i < 60; i++) 
			System.out.print("-");
		System.out.print("\nFinal sorted data: ");
		for (i = 0; i < size1+size2; i++)
			System.out.print(data3[i] + "  ");
	}

	public static void select_sort(int data[], int size)
	{
		int base=0, compare=0, min=0;
		int temp;

		for (base = 0; base < size-1; base++) {
			min = base;
			for (compare = base+1; compare < size; compare++)
				if (data[compare] < data[min])
					min = compare;
			temp = data[min];
			data[min] = data[base];
			data[base] = temp;
		}
	}

	public static void sorting(int size1, int size2)
	{
		int arg1 = 0, arg2 = 0, arg3 = 0, i = 0;

		data1[size1] = 32767;
		data2[size2] = 32767;
		arg1 = 0;
		arg2 = 0;
		for (arg3 = 0; arg3 < size1+size2; arg3++) {
			if (data1[arg1] < data2[arg2]) { // 比較兩數列，資料小的先存於合併後的數列
				data3[arg3] = data1[arg1];
				arg1++;
				System.out.printf("This step takes %d from data1\n", data3[arg3]);
			}
			else {
				data3[arg3] = data2[arg2];
				arg2++;
				System.out.printf("This step takes %d from data2\n", data3[arg3]);
			}
			System.out.print("Sorting...: ");
			for (i = 0; i < arg3+1; i++)
				System.out.print(data3[i] + "  ");
			System.out.print("\n\n");
		}
	}

	public static void main (String args[])  // 主函數		 
	{
		MergeSort obj = new MergeSort();
		obj.merge_sort();  
	}
}











