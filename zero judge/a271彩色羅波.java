import java.util.Scanner;
import java.util.StringTokenizer;
public class ZeroJudge {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner cin=new Scanner(System.in);
		int time=cin.nextInt();
		int[] rule=new int[6];	
		int count=0;
		for(int i=1;i<=time;i++){
			count=0;
			for(int j=0;j<=5;j++){
				rule[j]=cin.nextInt();//輸入增減體重的數據
				if(j==2||j==3||j==4){
					rule[j]=-rule[j];
				}				
				//System.out.println(rule[j]);
			}
			int poison=rule[4];//每次中毒所扣的血量
			int weight=rule[5];//初始的體重			
			cin.nextLine();
			String input=cin.nextLine();
			StringTokenizer eatSp=new StringTokenizer(input);
			while(eatSp.hasMoreTokens()){
				char temp=eatSp.nextToken().charAt(0);
				int tempI=temp-'0';
				if(tempI==0){
					if(count>0){//如果中毒數量大於0，就要每次都扣血
						weight+=poison;
					}		
					//System.out.println("不吃:"+weight);
					if(checkDead(weight)){	
						System.out.println("bye~Rabbit");
						break;
					}
				}
				if(tempI!=0){
					if(count>0){//如果中毒數量大於0，就要每次都扣血						
						weight+=poison;
						if(checkDead(weight)){
							System.out.println("bye~Rabbit");
							break;
						}
					}
					if(tempI-1==3){//計算每次扣的血量
						if(count==0){
							count++;
						}
						else{
							poison+=rule[4];//如果又中毒則每次扣的血量要累加上去
						}
					}				
					weight+=rule[tempI-1];									
					if(checkDead(weight)){
						System.out.println("bye~Rabbit");
						break;
					}
				}				
			}
			if(checkDead(weight)==false){
				System.out.println(weight+"g");
			}			
		}
		cin.close();
	}
	public static boolean checkDead(int weight){
		if(weight<=0){			
			return true;
		}
		return false;
	}
}
