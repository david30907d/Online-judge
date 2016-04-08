import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr={1,65,523,6,4,5,5,3,12,123,4,5123,12,13,45,4,53};
		Main.shell_sort(arr);
		output(arr);
	}
	public static void output(int[] arr){
		for (int i=0; i<arr.length;++i ) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void shell_sort(int[] arr){
		int n=arr.length;
		int h=1;
		while(h<n/3) h=3*h+1;//這樣就可以創出h的數列
		while(h>=1){
			for (int i=h;i<n ;i++ ) {
				int j=i;
				int left=arr[i];
				for (j=i; j>=h && arr[j-h]>left; j-=h ) {
					arr[j]=arr[j-h];
				}
				arr[j]=left;
			}
			h/=3;
		}
	}
}
