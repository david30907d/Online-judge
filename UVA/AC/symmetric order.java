import java.util.Arrays;
import java.util.Scanner;
public class Main{
	public static String[] arr = new String[20];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);		
		int count=0;
		while(cin.hasNext()){			
			int time=cin.nextInt();
			if(time==0) break;//end.

			count++;// count this is the xx time that executed.
			cin.nextLine();
			for(int c=0;c<time;++c){//input
				arr[c]=cin.nextLine();
			}

			boolean even=true;
			if((time&1)==1){
				even=false;//time is odd.
			}
			
			int ascend_end=0;
			if(even==true) ascend_end=time-1;
			else ascend_end=time;
			System.out.println("SET "+count);
			for(int i=0;i<ascend_end;i+=2){//if time-time%2 will make time be even!!
				System.out.println(arr[i]);
			}
			for(int i=(time-time%2)-1;i>=1;i-=2){
				System.out.println(arr[i]);
			}
		}
		cin.close();
	}	
}