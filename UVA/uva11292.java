import java.util.Arrays;
import java.util.Scanner;
class Main{
	static final int maxn=20000;
	public static Integer dragon[]=new Integer[maxn];
	public static Integer knight[]=new Integer[maxn];
	public static int dn=0,kn=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m=new Main();
		m.begin();
		
	}
	public void begin(){
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			dn=cin.nextInt();
			kn=cin.nextInt();
			if(dn==0&&kn==0){
				break;
			}
			for(int i=0;i<maxn;i++){
				dragon[i]=Integer.MAX_VALUE;
				knight[i]=Integer.MAX_VALUE;
			}
			for(int i=0;i<dn;i++){
				dragon[i]=cin.nextInt();
			}				
			for(int i=0;i<kn;i++){
				knight[i]=cin.nextInt();
			}	
			Arrays.sort(dragon);
			Arrays.sort(knight);
			int cur=0;
			int cost=0;
			for(int i=0;i<kn;i++){
				if(knight[i]>=dragon[cur]){
					cost+=knight[i];
					if(++cur>=dn)break;				
				}
			}
			if(cur==dn)System.out.println(cost);
			else System.out.println("Loowater is doomed!");
		}
		cin.close();
	}
}
