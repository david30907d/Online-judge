#include<iostream>
#include<cmath>
#include<cstring>
#include<stdio.h>
using namespace std;
int farray[40]={0};
int counter=1;
void fseries(){
	farray[0]=1;
	farray[1]=2;
	while(counter<38){//ノㄓミ禣Α计 
		farray[counter+1]=farray[counter]+farray[counter-1];
		counter++;
	}
}

int main(){
	int num=0;
	fseries();//ミ计
	while(scanf("%d",&num)!=EOF){
		for(int i=1;i<=num;i++){
			int j=0;//ノㄓボ禣计计index 
			int origininput;
			scanf("%d",&origininput);
			for(j=0;farray[j]<=origininput&&j<=38;j++){//тゑinput临璶禣计计礛搭 
					
			}
			j--;			
			
			int answer[50]={};
			int index=0;
			int input=origininput;
			while(input>0&&j>=0){
				if(farray[j]<input){//狦砆琘禣ㄆ计倒搭奔玥ê碞琌1 
					input=input-farray[j];
					answer[index++]=1;					
					/*
					answer=answer+1;
					answer*=10;*/
				}
				else if(farray[j]==input){//狦单琘禣ㄆ计玥–常琌0 
					input=input-farray[j];
					answer[index++]=1;					
					for(int k=j-1;k>=0;k--){
						answer[index++]=0;
					}
				}
				else{//狦input瞷ゑ禣ㄆ计临玥硂计碞恶箂 
					answer[index++]=0;
				}
				j--;
			}
			printf("%d = ",origininput);
			for(int i=0;i<index&&i<50;i++){
				printf("%d",answer[i]);	
			}
			printf(" (fib)\n");						
		}
	}	
 	return 0;
}


