import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;
public class Main{		
	//diff is the array that store the difference
	//between each steps ( the changes)
	public static char[] stuff = new char[105];	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);			
		double year=0;	
		while(cin.hasNext()){					
			int time=cin.nextInt();
			for(int t=1;t<=time;t++){
				System.out.println("Scenario #"+t+":");
				int left=cin.nextInt();
				int right=cin.nextInt();
				int left_count=0, right_count=0;
				int add=0;
				while(left!=1 || right!=1){
					if(left>right){
						add=(int)Math.floor((left-1)/right);
						left_count+=add;
						left-=add*right;
					}
					else{
						add=(int)Math.floor((right-1)/left);
						right_count+=add;
						right-=add*left;
					}					
				}
				System.out.println(left_count+" "+right_count);
				System.out.println();
			}
		}
		cin.close();		
	}				
}
