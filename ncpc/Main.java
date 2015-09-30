import java.util.Scanner;
class Main{	
	public static int first[][]=new int[100][100];
	public static int second[][]=new int[100][100];	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);	
		while(cin.hasNext()){			
			int num=cin.nextInt();
			for(int i=0;i<num;++i){
				int third[][]=new int[100][100];
				int n=cin.nextInt();
				int m=cin.nextInt();
				int p=cin.nextInt();
				for(int j=0;j<n;++j){
					for(int k=0;k<m;++k){
						first[j][k]=cin.nextInt();
					}
				}
				for(int j=0;j<m;++j){
					for(int k=0;k<p;++k){
						second[j][k]=cin.nextInt();
					}
				}				
				for(int j=0;j<m;++j){
					for(int k=0;k<p;++k){
						for(int x=0;x<n;++x){
							third[x][k]+=first[x][j]*second[j][k];
						}
					}
				}
				int max=third[0][0];
				for(int j=0;j<n;++j){				
					for(int k=0;k<p;++k){
						if(third[j][k]>max)max=third[j][k];
					}				
				}
				System.out.println(max);
			}
		}
		cin.close();
		
	}	
}
