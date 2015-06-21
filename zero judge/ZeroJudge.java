import java.util.Scanner;
public class ZeroJudge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0;
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt()){
			n=cin.nextInt();
			if(n==0){
				break;
			}
			for(int i=1;i<=n;i++){
				for(int j=n-i;j>=1;j--){
					System.out.printf("_");
				}
				for(int k=1;k<=i;k++){
					System.out.printf("+");
				}
				System.out.printf("\n");
			}
		}
		cin.close();
	}

}
