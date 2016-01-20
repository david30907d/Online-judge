import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;
public class Main{		
	//diff is the array that store the difference
	//between each steps ( the changes)
	public static int[] ans = new int[1020];
	public static boolean firsttime=true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);			
		while(cin.hasNext()){					
			int len=cin.nextInt();
			if(len==0) break;// the end.
			
			if(firsttime==false){
				System.out.println();
			}			
			int input=-1;			
			while(true){
				input=cin.nextInt();
				if(input==0) break;//end input.
				else ans[0]=input;
				for(int i=1;i<len;++i){
					ans[i]=cin.nextInt();
				}

				rail(ans, len);
			}
			firsttime=false;	
		}
		cin.close();		
	}			
	public static void rail(int[] ans, int len){
		Stack s=new Stack();
		int index=0;
		int i=1;
		boolean checkinInput=false;
		boolean checkPush=false;
		while(i<=len){
			if(ans[index] == i){
				index++;
				i++;
				checkinInput=true;
				//符合的話就進行下一個比對
			}
			if(s.empty()==false && ans[index] == ((Integer)s.peek()).intValue()){
				index++;
				s.pop();
				checkPush=true;				
			}
			if(checkPush==false && checkinInput==false){
				s.push((i++));//不合就push				
			}
		}
		while(s.empty()!=true){
			if(ans[index] == ((Integer)s.peek()).intValue()){
				//s.peek()得到的型態是Integer,但是在判斷是的時候編譯器說他是Object型態，所以只好把他轉成Integer然後再取一次值了
				index++;
				s.pop();
			}
			else{
				System.out.println("No");
				return;
			}
		}
		if(s.empty()){
			System.out.println("Yes");
			return;
		}		
	}
}
