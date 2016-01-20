import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;
public class Main{		
	//diff is the array that store the difference
	//between each steps ( the changes)
	public static char[] stuff = new char[105];
	public static Stack val=new Stack();
	public static Stack op=new Stack();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);			
		String input=null;	
		int loop=0;	
		while(cin.hasNext()){					
			input=cin.nextLine();
			for(int i=0;i<input.length();++i){
				if(input.charAt(i)!=' '){//把空白去掉
					//stuff[0]=input.charAt(i);					
					counting( input.charAt(i) );
				}				
			}
			
			while(op.empty()!=true){
				calc();
			}
			System.out.printf("Expression %d: %c\n", ++loop, (((Integer)val.peek()).intValue()==1 ? 'V' : 'F'));   //val的棧底元素即為當前運算式值
		}
		cin.close();		
	}			
	public static void counting(char c){
		if (c == '(') {         //若c == ‘(’，則0壓入算符棧op
		    op.push(0);
		} else if (c == ')') {   //若c == ‘)’，則處理括弧內的所有運算，結果入val棧
		    while (op.empty()!=true && ((Integer)op.peek()).intValue() != 0) 
		        calc();
		    op.pop();       // op棧頂的‘(’出棧
		    insert(((Integer)val.pop()).intValue());
		} else if (c == '!') {    //若c ==‘!’，則3壓入算符棧op
		    op.push(3);
		} else if (c == '&') {   //若c == ‘&’，則相繼將op棧頂的‘&’或‘!’彈出，進行相應運算, 2壓入算符棧op
		    while (op.empty()!=true && ((Integer)op.peek()).intValue() >= 2) 
		        calc();
		    op.push(2);
		} else if (c == '|') {    //若c ==‘|’，則相繼將op棧頂的‘|’、‘&’、‘!’彈出，進行相應運算, 1壓入算符棧op
		    while (op.empty()!=true && ((Integer)op.peek()).intValue() >= 1)
		        calc();
		    op.push(1);
		} else if (c == 'V' || c == 'F') {//若c是運算元，則轉化為數字後壓入val棧
		    insert(c == 'V' ? 1 : 0);
		}                        // 空格被忽略
	}
	public static void insert(int value)                    
	{	//運算元value壓入數值堆疊val
	    while (op.empty()!=true && ((Integer)op.peek()).intValue() == 3) { //根據op棧頂的’!’對運算元value進行非運算
	        value = (value==0 ? 1 : 0);
	        op.pop();
	    }
	    val.push(value);                //運算元b壓入數值棧val
	}
	public static void calc()                    //進行雙目運算
	{
	    int b = (Integer) val.pop();             //數值棧val棧頂中彈出兩個運算元a和b
	    int a = (Integer) val.pop();
	    int oper = (Integer) op.pop();           //算符棧op彈出棧頂算符oper
	    int value = (a & b);               // 默認算符為 &
	    if (oper == 1)                 // 處理算符為 | 的情況
	        value = (a | b);
	    insert(value);                    // 將運算結果插入值堆疊val中
	}
}
