/* 快速排序                  */
/* File name: QuickSort.java */
/* Version 1.0, 5-25-2008    */

import java.io.*;
import java.util.Scanner;

class QuickSort 
{
	static int temp = 0;
 
	public static void quick_sort(int data[])
	{
		Scanner keyboard = new Scanner(System.in);
		String st="";
		int size = 0, i = 0;

		System.out.print("\nPlease enter number to sort ( enter 0 when end ):\n");
		do {
			System.out.printf("#%-2d number : ", ++i);
			data[size] = keyboard.nextInt();
 		} while (data[size++] != 0);
		for (i = 0; i < 60; i++) 
			System.out.print("-");
		System.out.print("\n");
		sorting(data, 0, --size-1, size-1);
		for (i = 0; i < 60; i++)
			System.out.print("-");
		System.out.print("\nFinal sorted data : ");
		for (i = 0; i < size; i++)
			System.out.print(data[i] + "  ");
	}

	public static void sorting(int data[], int left, int right, int size)
	{  // left與right分別表欲排序資料兩端

		int lbase = 0, rbase = 0, i = 0;
		if (left < right) {
			lbase = left+1;		
			while (data[lbase] < data[left]) {
				if (lbase+1>size)
					break;
				lbase++;
			}
			rbase = right;		 
			while (data[rbase] > data[left]) 
				rbase--;
			while (lbase < rbase) { // 若lbase小於rbase，則兩資料對調
				temp = data[lbase];
				data[lbase] = data[rbase];
				data[rbase] = temp;
				lbase++;
				while (data[lbase] < data[left]) 
					lbase++;
				rbase--;
				while (data[rbase] > data[left]) 
					rbase--;
			}
			temp = data[left];  // 此時lbase大於rbase，則rbase的資料與第一筆對調
			data[left] = data[rbase];
			data[rbase] = temp;
			System.out.print("sorting : ");
			for (i = 0; i <= size; i++)
				System.out.printf("%4d", data[i]);
			System.out.print("\n");
			sorting(data, left, rbase-1, size);
			sorting(data, rbase+1, right, size);
		}
	}  
      
	public static void main (String args[])  // 主函數		 
	{
		QuickSort obj = new QuickSort();
		int[] data = new int[20];
		obj.quick_sort(data);  
	}
}










