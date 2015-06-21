#include<iostream>
#include<cstring>
#include<stdio.h>
using namespace std;
int main(){
	int n=0;
	int input[1000]={};	
	while(scanf("%d",&n)!=EOF){
		int i=0;
		for(i=0;i<n;i++){
			scanf("%d",&input[i]);
		}
		int min=0,temp=0;
		for(i=0;i<n;i++){
			min=i;
			for(int j=i+1;j<n;j++){				
				if(input[min]%10>input[j]%10){
					min=j;
				}
				if(input[min]%10==input[j]%10){
					if(input[min]<input[j]){
						min=j;
					}
					
				}
			}
			temp=input[i];
			input[i]=input[min];
			input[min]=temp;
		}
		for(int i=0;i<n;i++){
			if(i==n-1){
				printf("%d\n",input[i]);
			}
			else{
				printf("%d ",input[i]);
			}			
		}
	}
	return 0;	
} 
