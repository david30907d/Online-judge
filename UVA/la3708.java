import java.util.Scanner;
class Main{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m=new Main();
		m.begin();
		
	}
	public void begin(){
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int num=cin.nextInt();
			int add=cin.nextInt();
			double ans=0.0;
			for(int i=1;i<num;i++){
				double pos=(double)i/num*(num+add);
				ans+=Math.abs(pos-Math.floor(pos+0.5))/(num+add);
			}
			System.out.printf("%.4f\n",ans*10000);
									
		}
		cin.close();
	}
}
