import java.util.Scanner;
class Main{	
	public static long cycle[]=new long[1000001];
	// declare cycle into long because 3n+1 may
	// let the index (which must be int)
	// out of the limit of int!!!
	// so input must be long!!!
	//之所以會發生ArrayIndexOutOfBound是因為當input超過999999範圍的時候會傳到第一個if
	//再那裡會做很多3n+1的乘法，一旦超過int範圍就會變成負數，如果用long去處存就不會變成負數
	//等到小於999999時又再傳回else if，然後就一定是會再int的範圍內，另外陣列的index只能用int去存取
	public static long cycleLength(long input){
		if(input>999999){
			if((input&1)==1){
				return cycleLength(3*input+1)+1;
			}
			else{
				return cycleLength(input>>1)+1;
			}
		}
		else if(input<=999999&&cycle[(int) input]==0){
			if((input&1)==1){//&1 means mod 2 == 1
				cycle[(int) input]=(cycleLength(input*3+1)+1);
			}
			else{
				cycle[(int) input]=cycleLength(input>>1)+1;
				// >>1 means floor(input/2)
			}
		}
		return cycle[(int) input];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		cycle[1]=1;
		while(cin.hasNext()){			
			long start=cin.nextLong(),end=cin.nextLong();
			long max=0;
			System.out.print(start+" "+end);
			long temp=0;
			if(start>end){
				temp=start;
				start=end;
				end=temp;
			}
			for(long i=start;i<=end;++i){
				max=Math.max(max,cycleLength(i));
			}
			System.out.println(" "+max);
		}
		cin.close();
		
	}	
}
