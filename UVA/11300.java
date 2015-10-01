import java.util.Scanner;
import java.util.Arrays;
class Main{	
	public static long input[]=new long[1000000];
	public static long diff[]=new long[1000000];
	//diff is the array that store the difference
	//between each steps ( the changes)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);	
		while(cin.hasNext()){			
			int num=cin.nextInt();
			long sum=0;
			for(int i=0;i<num;++i){
				input[i]=cin.nextLong();
				sum+=input[i];
			}
			long aver=sum/num;//aver is average of amount that a person need to get
			diff[0]=0;
			for(int i=1;i<num;++i){
				diff[i]=diff[i-1]+input[i]-aver;
			}
			Arrays.sort(diff,0,num);
			//sort(formIndex,toIndex)
			//formIndex is inclusive, toIndex is exclusive;
			long mid=diff[num/2],ans=0;
			for(int i=0;i<num;++i){
				ans+=Math.abs(mid-diff[i]);
			}
			System.out.println(ans);
		}
		cin.close();
		
	}	
}
