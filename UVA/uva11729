import java.util.Arrays;
import java.util.Scanner;

class Main{
	private class job implements Comparable<job>{
		//this is an inner class, which shoud implements Comparable interface
		//Comparable<job> this statement is unknown!!
		public int command,exe;
		public job(){
			//super();
			command=0;
			exe=0;
		}		
		public int compareTo(job comP){
			//each class which implements Comparable need to define 
			//'compareTo' this method, for the sake of using Arrays.sort this method.
			if(this.exe<comP.exe){
				return -1;
			}
			else if(this.exe>comP.exe){
				return 1;			
			}
			else return 0;
		}		
	}
	public static int maxn=1000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m=new Main();
		m.begin();
		
	}
	public void begin(){
		job j[]=new job[maxn];
		Scanner cin=new Scanner(System.in);		
		int num=0;
		int caseN=1;
		while(cin.hasNext()){			
			num=cin.nextInt();
			if(num==0)break;
			for(int i=0;i<num;i++){
				j[i]=new job();
				//Objects need to be initiate, or it
				//will be null which cannot be sorted
			}			
			for(int i=0;i<num;i++){
				j[i].command=cin.nextInt();
				j[i].exe=cin.nextInt();
			}
			Arrays.sort(j,0,num);	
			//only sort num amounts of JOB objects
			int cur=0,max=0;
			for(int i=num-1;i>=0;i--){
				cur+=j[i].command;
				max=max(cur+j[i].exe,max);
			}
			System.out.println("Case "+(caseN++)+": "+max);
		}
		cin.close();
	}
	public static int max(int x,int y){
		if(x>y)return x;
		else return y;
	}
}
