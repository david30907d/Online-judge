#include <stdio.h>
#include <stdlib.h>
int check(int num);
int prime[1000000]={2,3,5,7};//办借计皚
void buildprime(); 
int main(int argc, char *argv[]) {
	int input=0;
	buildprime();//ミ借计 
	while(scanf("%d",&input)!=EOF){
		int i=0;
		int flag=0;
		if(check(input)){
			printf("借计\n");
		}
		else{
			printf("獶借计\n");
		}
	}
	return 0;
}
int check(int num){//耞琌借计 
	int i=0;
	for(i=0;prime[i]*prime[i]<=num;i++){
		if(num%prime[i]==0){
			return 0;//ぃ琌借计 
		}
	}
	return 1;
}
void buildprime(){//ミ借计 
	int currentPrime=7;//и瞷衡7借计 
	int i=0,j=0;
	for(i=4,j=4;currentPrime<1000000;i++,j=6-j){//i琌皚indexj琌2蛤が传北计沮
		 currentPrime=currentPrime+j;
		 if(check(currentPrime)==1){
		 	prime[i]=currentPrime;
		 }
		 else{
		 	i--;
		 }
	}
}

