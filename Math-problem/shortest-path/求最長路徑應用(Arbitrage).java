import java.util.Scanner;
import java.math.BigDecimal;
public class Main{		
	//diff is the array that store the difference
	//between each steps ( the changes)
	public static String[] dollars = new String[31];
	public static double[][] rate = new double[1020][1020];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);	
		int cas=1;
		while(cin.hasNext()){	
			
			int dol_num =0;int exchange_num=0;
			dol_num=cin.nextInt();	
			cin.nextLine();
			for(int i=0;i<dol_num;++i){
				dollars[i]=cin.nextLine();
			}//input dollars name.

			exchange_num=cin.nextInt();
			String m1, m2;
			double temp=0.0;
			for(int i=0;i<exchange_num;++i){
				m1=cin.next();
				temp=cin.nextDouble();
				m2=cin.next();
				rate[return_dollar_index(m1, dol_num)][return_dollar_index(m2,dol_num)]=temp;
			}//這樣各貨幣的匯率就已經存入了

			for(int k=0;k<dol_num;++k){
				for(int i=0;i<dol_num;++i){
					for(int j=0;j<dol_num;++j){
						if(rate[i][k]*rate[k][j]>rate[i][j] && i!=j&&j!=k&&k!=i){
							rate[i][j]=rate[i][k]*rate[k][j];
						}
					}
				}
			}

			boolean earn=false;
			for(int i=0;i<dol_num;++i){
				for (int j=0;j<dol_num ;++j ) {
					if(rate[i][j]*rate[j][i]>1 ) earn=true;
				}				
			}		
			System.out.println("Case "+(cas++)+": " + (earn?"Yes":"No"));
		}
		cin.close();
		
	}			
	public static int return_dollar_index(String d, int dol_num){
		for(int i=0;i<dol_num;++i){
			if(d.equals(dollars[i])) return i;
		}
		return -1;//代表沒找到這種貨幣名稱
	}
}
