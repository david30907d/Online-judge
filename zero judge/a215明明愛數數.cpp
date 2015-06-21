#include<iostream>
#include<cstring>
#include<stdio.h>
using namespace std;
int main(){
	int first=0;
	int second=0;
	while(scanf("%d %d",&first,&second)!=EOF){
		int counter=1,sum=first;
		for(int i=1;i<=100000;i++){
			if(first>second){
				printf("1\n");
				break;
			}
			sum=sum+first+i;			
			counter++;
			if(sum>second){
				printf("%d\n",counter);
				break;
			}
			
		}
	}
	return 0;	
} 
