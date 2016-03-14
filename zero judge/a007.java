import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
class Main{
	public static int[] prime = new int[100360];
	public static int index;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);		
		index=4;
		prime[0]=2;
		prime[1]=3;
		prime[2]=5;
		prime[3]=7;
		buildprime();
		while(cin.hasNext()){
			int input=cin.nextInt();
			if(check(input)) System.out.println("質數");
			else System.out.println("非質數");

		}
		cin.close();
	}	
	public static boolean check(int num){
		for(int i=0;i<index && prime[i]*prime[i]<=num; ++i){
			if(num%prime[i]==0) return false;//not prime.
		}
		return true;// is prime.
	}
	public static void buildprime(){
		int currentprime=7;
		int jump=4;
		for(index=4, jump=4; currentprime<1001000;index++, jump=6-jump){
			currentprime+=jump;
			if(check(currentprime)==false){// not prime.
				index--;
			}
			else{
				prime[index]=currentprime;
			}
		}
		index--;//now the index is the total num of prime.
	}
}
