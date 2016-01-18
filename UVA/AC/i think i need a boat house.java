import java.util.Arrays;
import java.util.Scanner;
class Main{
	public static int[] arr = new int[20];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);	
		int time=cin.nextInt();
		for(int count=1;count<=time;++count){
			double x=cin.nextDouble();
			double y=cin.nextDouble();
			double temp_ans=(x*x+y*y)*Math.PI/2/50;
			int ans = (int) (Math.ceil(temp_ans));
			System.out.println(ans);
		}
		cin.close();
	}	
}