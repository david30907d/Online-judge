#include <stdio.h>
#include <stdlib.h>
int check(int num);
int prime[10030]={2,3,5,7};
int index=4;//index is the total num of prime.
void buildprime(); 
int main(int argc, char *argv[]) {
	int input=0;
	buildprime(); 	
	while(scanf("%d",&input)!=EOF){
		if(input == 0){// 0 is the end of program.
			break;
		}

		int sum=0, amount=0;
		for (int i=0; prime[i]<=input; i++){
			sum=0;
			for(int j=i;prime[j]<=input && sum < input;++j){
				sum+=prime[j];
			}
			if(sum==input) amount++; 
		}

		printf("%d\n", amount);

	}
	return 0;
}
int check(int num){ 
	int k=0;
	for(k=0;k<index&&prime[k]*prime[k]<=num;k++){
		if(num%prime[k]==0){
			return 0;//0 means not prime
		}
	}
	return 1;// 1 means prime
}
void buildprime(){ 
	int currentPrime=7; 
	int j=4;
	for(index=4,j=4;currentPrime<10010;index++,j=6-j){//10010 means i only want to find the prime that's not greater than 10010.
		 currentPrime += j;
		 if(check(currentPrime)==1){// it's prime
		 	prime[index]=currentPrime;
		 }
		 else{
		 	index--;
		 }
	}
	index--;
}
