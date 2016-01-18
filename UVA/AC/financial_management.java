import java.util.Scanner;
import java.math.BigDecimal;
public class Main{		
	//diff is the array that store the difference
	//between each steps ( the changes)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);	
		while(cin.hasNext()){			
			double sum=0.0;
			for(int i=1;i<=12;++i){
				sum+=cin.nextDouble();
			}
			sum =sum/12;
			sum = new BigDecimal(sum).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();//let it to round of to second position after '.'
			System.out.println("$"+sum);
		}
		cin.close();
		
	}	
}