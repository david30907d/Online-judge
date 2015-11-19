import java.util.*;
public class Permutation {
	public static int[] p=new int[20];
	public static void main(String[] args){
		Scanner cin=new Scanner(System.in);
		int input=cin.nextInt();
		for(int i=0;i<input;i++){
			p[i]=i+1;
		}
		perm(p,0,input);//permutation就是排列
	}	
	public static void perm(int p[],int x,int y){
		//x就是固定整個陣列的第幾位，然後把x與後面一位交換
		if(x==(y-1)){
			for(int i=0;i<y;i++){
				System.out.print(p[i]);
			}			
			System.out.println();
		}
		else{
			for(int i=x;i<y;i++){//這裡的i從x起始，重要！！
				int temp=p[x];
				p[x]=p[i];
				p[i]=temp;
				perm(p,x+1,y);//每次x都會進位，進位完就會跟陣列的下一位交換
				temp=p[x];
				p[x]=p[i];
				p[i]=temp;
			}
		}
	}
}
