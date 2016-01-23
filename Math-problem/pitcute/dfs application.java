import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
class Main{
	public static int[][] map = new int[6][6];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);		
		builmap();
		String ans="";						
		printpath(1,0,ans);		
	}	
	public static void printpath(int point, int len, String ans){//it's a kind of dfs.
		char add=(char)('0'+point);//turn point into type of char.
		ans=ans+add;//concatinate add into ans.
		if(len==8){
			System.out.println(ans);
			return;
		}		
		for(int j=1;j<=5;++j){
			if(map[point][j] == 1){
				map[point][j]=map[j][point]=0;
				printpath(j, len+1, ans);
				map[point][j]=map[j][point]=1;
			}
		}	
	}
	public static void builmap(){
		for(int i=1;i<=5;++i){
			for(int j=1;j<=5;++j){
				if(i!=j){
					map[i][j]=1;					
				}
			}
		}
		map[4][1]=map[1][4]=0;
		map[4][2]=map[2][4]=0;
	}
}
