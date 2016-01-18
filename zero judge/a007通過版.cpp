#include <stdio.h>
#include <stdlib.h>
int check(int num);
int prime[1000000]={2,3,5,7};
int i=4;
void buildprime(); 
int main(int argc, char *argv[]) {
	int input=0;
	buildprime(); 
	while(scanf("%d",&input)!=EOF){
		if(check(input)){
			printf("it's a prime\n");
		}
		else{
			printf("not prime \n");
		}
	}
	return 0;
}
int check(int num){ 
	int k=0;
	for(k=0;k<i&&prime[k]*prime[k]<=num;k++){
		if(num%prime[k]==0){
			return 0;//0 means not prime
		}
	}
	return 1;// 1 means prime
}
void buildprime(){ 
	int currentPrime=7; 
	int j=4;
	for(i=4,j=4;currentPrime<999999;i++,j=6-j){
		 currentPrime += j;
		 if(check(currentPrime)==1){// it's prime
		 	prime[i]=currentPrime;
		 }
		 else{
		 	i--;
		 }
	}
}
