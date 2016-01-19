import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main{
	public static String[] notation = {"``", "''"};
	public static boolean order=true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);				
		while(cin.hasNext()){
			String input=cin.nextLine();
			for(char c:input.toCharArray()){
				if(c=='\"'){
					System.out.printf("%s", order?"``":"''");
					order=!order;
				}
				else{
					System.out.print(c);
				}
			}
			System.out.println();			
		}
		cin.close();
	}	
	
}
