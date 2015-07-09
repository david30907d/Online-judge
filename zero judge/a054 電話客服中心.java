import java.util.Scanner;
import java.util.StringTokenizer;
public class JAVA {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner cin=new Scanner(System.in);		
		int[] list={10,11,12,13,14,15,16,17,34,18,19,20,21,22,35,23,24,25,26,27,28,29,32,30,31,33};
		while(cin.hasNext()){			
			String input=cin.nextLine();
			int sum=0;			
			for(int i=8;i>=1;i--){
				sum+=(input.charAt(8-i)-'0')*i;				
			}
			sum+=(input.charAt(8)-'0');
			int upper=0;
			for(int i=0;i<=25;i++){
				upper=0;
				upper=(list[i]%10)*9+list[i]/10;
				upper=upper%10;
				//System.out.println(upper+" "+sum);		
				if((upper+sum)%10==0){
					System.out.printf("%c",i+65);
				}
			}	
			System.out.println();
		}
	}	
}
