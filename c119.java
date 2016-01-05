import java.util.Scanner;
public class big_number {	
	public static int[] work=new int[2568];
	public static int[] record=new int[1005];
	public static void main(String[] args) {
		// TODO Auto-generated method stub					
		Scanner cin=new Scanner(System.in);	
		work[0]=1;	
		record[0]=1;
		int length=1;
		for(int i=1;i<=1000;++i){
			int count=0;
			for(int j=0;j<length;++j){
				work[j]*=i;
			}
			for(int j=0;j<length;++j){
				if(work[j]>=10){					
					work[j+1]+=work[j]/10;
					work[j]=work[j]%10;
					if(length<2568){
						length++;
					}
				}
				count+=work[j];
			}
			record[i]=count;
		}
		while(cin.hasNext()){	
			int input=cin.nextInt();
			System.out.println(record[input]);
		}
		cin.close();
	}
	
}
