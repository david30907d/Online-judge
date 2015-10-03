import java.util.Scanner;
class Main{	
	public static long cycle[]=new long[1000001];
	// declare cycle into long because 3n+1 may
	// let the index (which must be int)
	// out of the limit of int!!!
	// so input must be long!!!
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
