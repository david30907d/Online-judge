#include <stdio.h>
#include <stdlib.h>
int check(int num);
int prime[1000000]={2,3,5,7};
int i=4;
void buildprime(); 
int main(int argc, char *argv[]) {
	int n1=0,n2=0;
	int counter=0;
	buildprime(); 
	while(scanf("%d %d",&n1,&n2)!=EOF){
		int counter=0;
		for(int i=n1;i<=n2;i++){
			if(check(i)&&i!=1){//i!=1是因為他測資最小會是1，1丟進check會是true!! 
				counter++;
			}
		}
		printf("%d\n",counter);
	}
	return 0;
}
int check(int num){ 
	int k=0;
	for(k=0;k<i&&prime[k]*prime[k]<=num;k++){
		if(num%prime[k]==0){
			return 0;
		}
	}
	return 1;
}
void buildprime(){ 
	int currentPrime=7; 
	int j=4;
	for(i=4,j=4;currentPrime<999999;i++,j=6-j){
		 currentPrime=currentPrime+j;
		 if(check(currentPrime)==1){
		 	prime[i]=currentPrime;
		 }
		 else{
		 	i--;
		 }
	}
}

