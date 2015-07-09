import java.util.Scanner;
import java.util.StringTokenizer;
public class JAVA {	
	public static int[] prime=new int[1000000];//建立一百萬個植樹
	public static int i=4;//因為2、3、5、7不和規律所以先建立，然後從第四個質數開始建
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner cin=new Scanner(System.in);		
		prime[0]=2;
		prime[1]=3;
		prime[2]=5;
		prime[3]=7;
		buildprime();
		while(cin.hasNext()){	
			int num=cin.nextInt();
			if(num==0){
				break;
			}
			if(num==1){
				System.out.println("1");				
			}
			else if(check(num)==0){
				System.out.println("1");
			}
			else{
				System.out.println("0");
			}
		}
		cin.close();
	}	
	public static int check(int num){ 
		int k=0;
		for(k=0;k<i&&prime[k]*prime[k]<=num;k++){//離散的概念，只要檢查平方後小於他的數能不能整除他就好
			if(num%prime[k]==0){//不實質數就回傳0
				return 0;
			}
		}
		return 1;//是就傳1
	}
	public static void buildprime(){ 
		int currentPrime=7; 
		int j=4;
		for(i=4,j=4;i<=999999;i++,j=6-j){//用+2和+4去算是因為去掉這兩個數的倍數就可以省掉很多時間了
			 currentPrime=currentPrime+j;
			 if(check(currentPrime)==1){
			 	prime[i]=currentPrime;
			 }
			 else{
			 	i--;
			 }
		}
	}
}
