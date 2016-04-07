import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr={1,65,523,6,4,5,5,3,12,123,4,5123,12,13,45,4,53};
		Main.insertion(arr);
	}
	public static void insertion(int[] arr){
		  int left,j=0;
		  for(int i=1;i<arr.length;++i){
			  left=arr[i];
			  for(j=i-1;j>=0&&arr[j]>left;--j){
				  arr[j+1]=arr[j];
			  }
			  arr[j+1]=left;
		  }
	  }
}
