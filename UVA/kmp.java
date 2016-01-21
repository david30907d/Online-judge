import java.util.Scanner;
import java.math.BigDecimal;
public class Main{		
	//diff is the array that store the difference
	//between each steps ( the changes)
	public static int[] failure = new int[100];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);					
		while(cin.hasNext()){					
			String input=cin.nextLine();
			String pattern = cin.nextLine();
			failure(pattern);
			
			for(int i=0;i<=10;i++){
				System.out.print(" "+failure[i]);
			}			
			Morris_Pratt(input, pattern);
		}
		cin.close();
		
	}		
	
	// 目前比對成功的字串片段是p[0...i-1]
	// 大幅挪動P之後，比對成功的部份剩下P[0...failure[i-1]]。	
	public static void Morris_Pratt(String t, String p)
	{
	    if (p.length() > t.length()) return;
	 
	    // 預先計算 P 的 failure function，O(P)。
	    failure(p);
	 
	    // 進行字串匹配，O(T)。
	    for (int i=0, j=-1; i<t.length(); ++i)
	    {
	        // 先試 p[0...j] 的「最長的相同前綴後綴」，
	        // 再試「次長的相同前綴後綴」，
	        // 再試「次次長的相同前綴後綴」……
	        // 直到試成功為止。
	        while (j >= 0 && p.charAt(j+1) != t.charAt(i))
	            j = -1;
	 
	        // t[i] 終於有用處了，終於可以加長！
	        if (p.charAt(j+1) == t.charAt(i)) j++;
	 
	        // 匹配到P！
	        if (j == p.length()-1)
	        {
	            System.out.println("P出現位置" +(i - p.length() + 1)); 
	 
	            // 如果字串結尾不是'\0'的時候，就必須挪動 P。
	            // 如果字串結尾是'\0'的時候，就能省略這一行。
	            j = failure[j];
	        }
	    }
	}
	 
	public static void failure(String p)
	{
	    // iterative, bottom-up DP
	    for (int i=1, j=failure[0]=-1; i<p.length(); ++i)
	    {
	        // 先試 p[0...i-1] 的「次長的相同前綴後綴」，
	        // 也就是 p[0...failure[i-1]] = p[0...j]。
	        // 再試 p[0...j] 的「次長的相同前綴後綴」，
	        // 也就是 p[0...failure[j]]。
	        // 再試 p[0...failure[j]] 的「次長的相同前綴後綴」……
	        // 直到試成功為止。
	        while (j >= 0 && p.charAt(j+1) != p.charAt(i))
	            j = -1;//
	 
	        // p[i] 終於有用處了，終於可以加長！
	        if (p.charAt(j+1) == p.charAt(i)) j++;
	 
	        // 得到了 failure[i] 的值！
	        failure[i] = j;
	    }
	}
}
