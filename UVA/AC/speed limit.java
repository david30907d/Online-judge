import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main{
	public static int[] arr = new int[20];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);		
		while(cin.hasNext()){
			int input=cin.nextInt();
			if(input==-1){//end
				break;
			}

			int oldt=0, sum=0;
			for(int i=1;i<=input;++i){
				int s=cin.nextInt();
				int t=cin.nextInt();
				sum+=s*(t-oldt);
				oldt=t;
			}

			System.out.println(sum+" miles");
		}
		cin.close();
	}	
}