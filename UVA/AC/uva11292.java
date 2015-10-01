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
				dragon[i]=Integer.MAX_VALUE;//Integer的最大值
			    //因為Arrays.sort只能排物件型態，又創物件陣列的時候全部都被預設為null
				//null時不能被排序的，所以我全部都填入最大值
				//這樣排序救回從低到高去排，沒用到的就會被放在最後不會去呼叫到他
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
			for(int i=0;i<kn;i++){//排列完後只去計算實際有輸入的數量
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
