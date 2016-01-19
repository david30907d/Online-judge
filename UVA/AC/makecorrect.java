import java.util.Arrays;
import java.util.Scanner;
public class Main{	
	public static int[][] matrix=new int[101][101];
	public static int oddrow=0;
	public static int countone=0;
	public static int oddcol=0;
	public static int lastrow,lastcol=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);						
		int size=0;
		while(cin.hasNext()){
			oddrow=0;
			countone=0;
			oddcol=0;
			lastrow=0;lastcol=0;
			size=cin.nextInt();
			if(size==0) break;//end		
			for(int i=1;i<=size;++i){//input
				for(int j=1;j<=size;++j){
					matrix[i][j]=cin.nextInt();
					if(matrix[i][j]==1) countone++;
				}
				if((countone&1)==1){//means countone is odd.
					oddrow++;
					countone=0;
					lastrow=i;
				}
			}

			for(int j=1;j<=size;++j){//input
				for(int i=1;i<=size;++i){					
					if(matrix[i][j]==1) countone++;
				}
				if((countone&1)==1){//means countone is odd.
					oddcol++;
					countone=0;
					lastcol=j;
				}
			}

			if(oddcol==0 && oddrow==0){
				System.out.println("OK");
			}
			else if(oddcol==1 && oddrow==1){
				System.out.println("Change bit ("+lastrow+","+lastcol+")");
			}
			else{
				System.out.println("Corrupt");
			}
		}
		cin.close();	
	}		
	
}
