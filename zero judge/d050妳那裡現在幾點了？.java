import java.util.Scanner;
import java.util.StringTokenizer;
public class ZeroJudge {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner cin=new Scanner(System.in);
		int time=cin.nextInt();
		if(time<15){
			time=24-(15-time);
			System.out.println(time);
		}
		else if(time>=15&&time<=23){
			System.out.println(time-15);
		}
		cin.close();
	}	
}
