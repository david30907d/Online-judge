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
			year=cin.nextInt()	;
			if(year==0) break;//0 is the end.

			double year_gap=Math.floor((year-1960)/10);
			double digit=Math.pow(2.0,2+year_gap);
			double sum=0;
			for(int i=1;i<=1000000;i++){//i<=1000000代表我猜他一定會小於1000000階的乘積
				//因為digit的極限是2的digit次方-1，所以可以保證他一定小魚digit
				//而為了怕溢位，下面都取log
				if(sum<digit){
					sum+=Math.log(i)/Math.log(2);//換底公視				
				}
				else{
					--i;
					System.out.println(--i);
					break;
				}
			}
		}
		cin.close();		
	}				
}
