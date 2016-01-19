import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main{	
	
	public static boolean hasfirst=false;
	public static class Poly{		
		public int term,degree;
		public Poly(){
			term=0;
			degree=0;
		}				
	}
	public static Poly p[]=new Poly[11];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);				
		for(int i=0;i<=10;++i){
			p[i]=new Poly();
		}

		while(cin.hasNext()){
			hasfirst=false;//initialization.
			for(int i=8;i>=0;--i){
				p[i].term=cin.nextInt();
				p[i].degree=i;
			}//input.

			if(checknull(p)==false){//這邊開始才是正常的執行，如果沒有進來代表多項式全為零
				for(int i=8;i>=0;--i){
					if(p[i].term!=0 && hasfirst==false){
						printfirst(p[i]);
					}
					else if(hasfirst==true){
						printelse(p[i]);
					}
				}
			}
			System.out.println();
		}
		cin.close();	
	}		
	public static boolean checknull(Poly[] p){
		for(Poly ip:p){
			if(ip.term!=0) return false;
		}//上面如果沒有return代表多項式都是零
		System.out.print("0");
		return true;
	}
	public static void printfirst(Poly p){	
		String degree=returndegree(p);	
		if(p.term==-1 && p.degree!=1){
			System.out.print("-x^"+degree);
		}
		else if(p.term==1 && p.degree!=1){
			System.out.print("x^"+degree);			
		}
		else if(p.degree==0){
			System.out.print(p.term);			
		}
		else if(p.degree==1 && p.term==1){
			System.out.print("x");			
		}
		else if(p.degree==1 && p.term==-1){
			System.out.print("-"+"x");			
		}		
		else{
			System.out.print(p.term+"x^"+degree);
		}
		hasfirst=true;
	}
	public static void printelse(Poly p){

		if(p.term!=0 && Math.abs(p.term)!=1 && p.degree!=1 && p.degree!=0){
			System.out.print((p.term>=0)?" + ":" - ");			
			System.out.print(Math.abs(p.term)+"x^"+p.degree);					
		}
		else if(p.term==0){
			return;
		}
		else if(Math.abs(p.term)==1 && p.degree>1){
			System.out.print((p.term>=0)?" + ":" - ");			
			System.out.print("x^"+p.degree);	
		}
		else if(Math.abs(p.term)==1 && p.degree==1){
			System.out.print((p.term>=0)?" + ":" - ");			
			System.out.print("x");	
		}
		else if(p.degree==1 && p.term!=0){
			System.out.print((p.term>=0)?" + ":" - ");			
			System.out.print(Math.abs(p.term)+"x");	
		}
		else if(p.degree==0){
			if(p.term!=0){
				System.out.print((p.term>=0)?" + ":" - ");			
				System.out.print(Math.abs(p.term));	
			}
		}		
		else{
			System.out.print("error");
		}
	}
	public static String returndegree(Poly p){
		if(p.degree==0){
			return "";
		}
		else{
			return Integer.toString(p.degree);
		}
	}
}
