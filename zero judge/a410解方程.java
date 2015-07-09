import java.util.Scanner;
import java.util.StringTokenizer;
public class JAVA {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner cin=new Scanner(System.in);		
		while(cin.hasNextInt()){
			double a=cin.nextInt();				
			double b=cin.nextInt();
			double c=cin.nextInt();
			double d=cin.nextInt();
			double e=cin.nextInt();
			double f=cin.nextInt();
			double x=0,y=0;
			if(a==0||b==0||d==0||e==0){//有係數為0
				if((a==0&&b==0&&c!=0)||(d==0&&e==0&&f!=0)){
					System.out.println("No answer");
				}				
				else if((a==0&&b==0&&c==0)||(d==0&&e==0&&f==0)){
					System.out.println("Too many");
				}
				else if(a==0&&d==0&&b!=0&&e!=0){
					double y2=f/e;
					y=c/b;
					if(y!=y2){
						System.out.println("No answer");
					}
					else{
						System.out.println("Too many");
					}
				}
				else if(a!=0&&d!=0&&b==0&&e==0){
					double x2=f/d;
					x=c/a;
					if(x!=x2){
						System.out.println("No answer");
					}
					else{
						System.out.println("Too many");
					}
				}
				else if(a==0&&b!=0&&d!=0){
					y=c/b;
					x=(f-e*y)/d;
					System.out.printf("x=%.2f%n",x);
					System.out.printf("y=%.2f%n",y);
				}
				else if(d==0&&e!=0&&a!=0){
					y=f/e;
					x=(c-b*y)/a;
					System.out.printf("x=%.2f%n",x);
					System.out.printf("y=%.2f%n",y);
				}
				else if(b==0&&a!=0&&e!=0){
					x=c/a;
					y=(f-d*x)/e;
					System.out.printf("x=%.2f%n",x);
					System.out.printf("y=%.2f%n",y);
				}
				else if(e==0&&d!=0&&b!=0){
					x=f/d;
					y=(c-a*x)/b;
					System.out.printf("x=%.2f%n",x);
					System.out.printf("y=%.2f%n",y);
				}				
			}
			else{//沒有任何一個係數為0
				if(check(a,b,c,d,e,f)==0){
					System.out.println("No answer");
				}
				else if(check(a,b,c,d,e,f)==1){
					System.out.println("Too many");
				}
				else{
					y=calY(a,b,c,d,e,f);
					x=(c-y*b)/a;
					System.out.printf("x=%.2f%n",x);
					System.out.printf("y=%.2f%n",y);
				}
			}
			
		}
		cin.close();
	}	
	public static int check(double a,double b,double c,double d,double e,double f){		
		double fac=a/d;
		if(b==fac*e&&c!=fac*f){
			return 0;//表示無解
		}
		else if(b==fac*e&&c==fac*f){
			return 1;//表示無限多組解
		}	
		else{
			return 2;//有唯一解
		}
	}
	public static double calY(double a,double b,double c,double d,double e,double f){
		double fac=0.0;
		fac=a/d;
		d*=fac;
		e*=fac;
		f*=fac;
		b-=e;
		c-=f;
		double y=c/b;
		return y;
	}
}
