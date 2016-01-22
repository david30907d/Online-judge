import java.util.Scanner;
import java.math.BigDecimal;
public class Main{		
	//diff is the array that store the difference
	//between each steps ( the changes)
	public static int[] failure = new int[100];
	public static String[] DNA = new String[12];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);					
		while(cin.hasNext()){	
			int time=cin.nextInt();
			for(int t=1;t<=time;++t){
				int amount=cin.nextInt();
				for(int m=0;m<amount;++m){//input DNA
					DNA[m]=cin.nextLine();
				}
				failure(DNA[0]);//把第一個DNA當作pattern先建一張表，以後遇到相同前後墜的時候就可以往前跳一大步
				for(int i=1;i<amount;++i){
					Morris_Pratt(DNA[1],DNA[0]);
				}
			}			
		}
		cin.close();
		
	}		
	
	// 目前比對成功的字串片段是p[0...i-1]
	// 大幅挪動P之後，比對成功的部份剩下P[0...failure[i-1]]。	
	public static void Morris_Pratt(String t, String p)
	{
	    if (p.length() > t.length()) return;	 	   
	 
	    // 進行字串匹配，O(T)。
	    for (int i=0, jump_length=-1; i<t.length(); ++i)
	    {
	        // 先試 p[0...jump_length] 的「最長的相同前綴後綴」，
	        // 再試「次長的相同前綴後綴」，
	        // 再試「次次長的相同前綴後綴」……
	        // 直到試成功為止。
	        while (jump_length >= 0 && p.charAt(jump_length+1) != t.charAt(i))
	            jump_length = -1;
	 
	        // t[i] 終於有用處了，終於可以加長！
	        if (p.charAt(jump_length+1) == t.charAt(i)) jump_length++;
	 
	        // 匹配到P！
	        if (jump_length == p.length()-1)
	        {
	            System.out.println("P出現位置" +(i - p.length() + 1)); 
	 
	            // 如果字串結尾不是'\0'的時候，就必須挪動 P。
	            // 如果字串結尾是'\0'的時候，就能省略這一行。
	            jump_length = failure[jump_length];
	        }
	    }
	}
	 
	public static void failure(String p)
	{
	    // iterative, bottom-up DP
	    for (int i=1, jump_length=failure[0]=-1; i<p.length(); ++i)
	    {
	        // 先試 p[0...i-1] 的「次長的相同前綴後綴」，
	        // 也就是 p[0...failure[i-1]] = p[0...jump_length]。
	        // 再試 p[0...jump_length] 的「次長的相同前綴後綴」，
	        // 也就是 p[0...failure[jump_length]]。
	        // 再試 p[0...failure[jump_length]] 的「次長的相同前綴後綴」……
	        // 直到試成功為止。
	        while (jump_length >= 0 && p.charAt(jump_length+1) != p.charAt(i))
	            jump_length = -1;//
	 
	        // p[i] 終於有用處了，終於可以加長！
	        if (p.charAt(jump_length+1) == p.charAt(i)) jump_length++;
	 
	        // 得到了 failure[i] 的值！
	        failure[i] = jump_length;
	    }
	}
}
