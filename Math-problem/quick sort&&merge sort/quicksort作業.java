import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class quicksort {
	public static int max=100000000;
	public static Random ran=new Random();
	public static mergesort m=new mergesort();
	public static int[] input=new int[max];	
	public static int[] compare1_input=new int[max];
	public static int[] compare2_input=new int[max];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=0;		
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			num=cin.nextInt();			
			for(int i=0;i<max;++i){
				input[i]=ran.nextInt(2147483647);
				compare1_input[i]=input[i];
				compare2_input[i]=input[i];				
			}			
			long begintime = System.currentTimeMillis();
			//m.Sort(input,max);//這是合併排序的方法
			//Sort(input);//這是quick sort的方法
			Arrays.sort(input);			
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("util's arrays.sort takes: "+costTime+"ms");
			
			begintime = System.currentTimeMillis();
			//m.Sort(input,max);//這是合併排序的方法
			Sort(compare1_input);//這是quick sort的方法
			//Arrays.sort(input);			
			endtime=System.currentTimeMillis();
			costTime = (endtime - begintime);
			System.out.println("quick sort takes: "+costTime+"ms");
			
			begintime = System.currentTimeMillis();
			m.Sort(compare2_input,max);//這是合併排序的方法
			//Sort(compare1_input);//這是quick sort的方法
			//Arrays.sort(input);			
			endtime=System.currentTimeMillis();
			costTime = (endtime - begintime);
			System.out.println("merge sort takes: "+costTime+"ms");
			
		}
		cin.close();
	}
	public static void Sort(int[] array)
    {
        Sort(array, 0, array.length - 1);
    }
 
    public static void Sort(int[] array, int left, int right)
    {
        if (right<=left){        
        	return;
        }
        // random pivot
        int pivotIndex = left + ran.nextInt(right - left + 1);
 
        // middle pivot
        //int pivotIndex = (left + right) / 2;
        int pivot = array[pivotIndex];
        Swap(array, pivotIndex, right);//先把pivot擺到最右班，這樣做的原因是因為方便for從左邊讀到右邊
        //只要有比piot還小的樹就交換到左半邊，交換的位置swapindex會一直遞移
        int swapIndex = left;
        for (int i = left; i < right; ++i)
        {
            if (array[i] <= pivot)
            {
                Swap(array, i, swapIndex);
                ++swapIndex;
            }
        }
        Swap(array, swapIndex, right);//把pivot擺回原位，這個時候pivot已經就定位了
        Sort(array, left, swapIndex - 1);
        Sort(array, swapIndex + 1, right);
    }
 
    private static void Swap(int[] array, int indexA, int indexB)
    {
        int tmp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tmp;
    }
}
