import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
class Main{
	public static int[] arr = new int[20];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);		
		while(cin.hasNext()){
			boolean end=false;
			String input = cin.nextLine();
			StringTokenizer s=new StringTokenizer(input);
			int index=0;
			while(s.hasMoreTokens()){//input
				int val=Integer.parseInt(s.nextToken());//cast type to int
				if(val==0){//0 means the end of this input
					break;
				}
				if(val==-1){//-1 means the end of test
					end=true;
					break;
				}				
				arr[index++]=val;
			}
			
			if(end==true){// the end of this program
				break;
			}

			int sum=0;
			for(int i=0;i<=index-1;++i){
				for(int j=0;j<=index-1;++j){
					if(arr[i]*2==arr[j]) sum++;
				}
			}

			System.out.println(sum);

		}
		cin.close();
	}	
}