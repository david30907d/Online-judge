import java.util.Scanner;
import java.util.StringTokenizer;
public class JAVA {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner cin=new Scanner(System.in);				
		while(cin.hasNext()){						
			String input=cin.nextLine();
			input=input.toUpperCase();
			if(input.charAt(0)=='0'&&input.length()==1){//這裡是陷阱題阿，題目說遇到0就停止的意思是單單一個0
				//但是若輸入01234則不用停止!!!!!
				break;
			}
			int sum=0;
			for(int i=0;i<input.length();i++){
				if(Character.isLetter((input.charAt(i)))==false){
					sum=-1;
					break;
				}
				else{
					sum+=input.charAt(i)-'A'+1;
				}
			}
			if(sum==-1){
				System.out.println("Fail");
			}
			else{
				System.out.println(sum);
			}			
		}	
		cin.close();
	}
		
}	
