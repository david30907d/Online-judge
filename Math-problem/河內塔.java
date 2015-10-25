package hanoi_Tower;
import java.io.*;
public class hanoi_Tower {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n;
		String str;
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		//bufferedReader比較常用在讀檔案，對象為非人類時用
		str=cin.readLine();	
		n=Integer.parseInt(str);
		//n為圓盤個數
		towers(n,'a','b','c');
	}
	public static void towers(int n,char a,char b,char c){
		if(n==1){
			System.out.println("把圓盤1"+"從"+a+"移動到"+c);
		}
		else{
			towers(n-1,a,c,b);
			//就是遞迴，把最大盤以上的所有盤子都放到b
			System.out.println("把圓盤"+n+"從"+a+"移動到"+c);
			//然後把最大盤丟到目的地c
			towers(n-1,b,a,c);
			//再把其他盤（其實是一大碟），從b移到c
			//因為是遞迴，所以他會一直按照這樣的邏輯，先把不要的那一疊丟到旁邊
			//然後再把目前最大的那一疊放到目的地，放完後再把那一疊移到目的地
		}
	}

}
