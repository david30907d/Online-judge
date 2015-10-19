package ncpc104a;
import java.util.Scanner;
import java.util.StringTokenizer;
public class ncpc104a {
	public static int[] record=new int[100000];//用來紀錄有幾種數字，且為按輸入時的順序
	public static int[] rawdata=new int[100000];//原始的資料陣列
	public static int count=0;//設定為全域比較好呼叫，用來計算record的陣列存到哪
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int time=cin.nextInt();
			cin.nextLine();
			for(int n=1;n<=time;n++){
				count=0;
				String input=cin.nextLine();
				StringTokenizer s=new StringTokenizer(input);
				int c=0;
				int ans=0,max=0,min=0,init=0;
				boolean findmin=false;
				while(s.hasMoreTokens()){					
					int val=Integer.parseInt(s.nextToken());
					rawdata[c++]=val;//這兩行就是儲存加建立數字表					
					build_list(val);
				}
				for(int i=0;i<count;i++){
					//看有幾種數字就要算幾次，所以是到count次
					for(int j=init;j<c;j++){
						//init是起始的座標，因為record的數字是按照輸入時的順序去放的（那個數字第一次出現時就會被放進去）
						//所以我只要保留min，也就是那種數字第一次出現的位置，我就可以保證下一次從min+1的位置開始檢查是ok的
						
						if(record[i]==rawdata[j]&&findmin==true){
							max=j;
						}
						else if(record[i]==rawdata[j]&&findmin==false){
							min=j;
							findmin=true;
						}
					}
					ans+=max+1;
					init=min+1;
				}
				System.out.println(ans);
			}
		}
		cin.close();
	}
	public static void build_list(int a){
		//如果這個數字沒有出現過就把他存進record
		boolean check=true;
		for(int i=0;i<count;i++){
			if(record[i]==a){
				check=false;
				break;
			}
		}
		if(check){
			record[count]=a;
			count++;
		}
	}
}
