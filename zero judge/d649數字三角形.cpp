#include<iostream>
#include<cstring>
#include<stdio.h>
using namespace std;
int main(){
	int n=0;
	while(scanf("%d",&n)){
		if(n==0){
			break;
		}
		for(int i=1;i<=n;i++){
			for(int j=n-i;j>=1;j--){
				printf("_");
			}
			for(int k=1;k<=i;k++){
				printf("+");
			}
			printf("\n");
		}
	}
	return 0;	
} 
