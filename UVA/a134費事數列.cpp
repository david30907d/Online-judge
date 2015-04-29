#include<iostream>
#include<cmath>
#include<cstring>
#include<stdio.h>
using namespace std;
int farray[30]={};
int counter=1;
void fseries(){
	farray[0]=1;
	farray[1]=2;
	while(counter<30){
		farray[counter+1]=farray[counter]+farray[counter-1];
		counter++;
	}
}
int j=0;
int main(){
	int num=0;
	fseries();
	//printf("%d %d\n\n",farray[0],farray[1]);
	while(scanf("%d",&num)!=EOF){
		
		for(int i=1;i<=num;i++){
			int origininput;
			scanf("%d",&origininput);
			for(j=0;farray[j]<=origininput;j++){//找到比input還要大的費數數字，然後減一 
				//printf("%d ",farray[j]);	
			}
			j--;
			//printf("\nfinal:%d ",farray[j]);
			
			int answer=0;
			int input=origininput;
			while(input>0){
				if(farray[j]<input){
					input=input-farray[j];
					answer=answer+1;
					answer*=10;
				}
				else if(farray[j]==input){
					input=input-farray[j];
					answer=answer+1;
					for(int k=j;j>0;j--){
						answer*=10;
					}
				}
				else{
					answer*=10;
				}
				j--;
			}
			printf("%d = %d (fib)\n",origininput,answer);
		}
	}	
 	return 0;
}


