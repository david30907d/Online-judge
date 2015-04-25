#include<iostream>
#include<cstring>
#include<stdio.h>
using namespace std;
int main(){
	int input=0;
	int score=0;
	while(scanf("%d",&input)!=EOF){
			if(input>=0&&input<=10){
				printf("%d\n",6*input);
			}
			else if(input>=11&&input<=20){
				printf("%d\n",60+(input-10)*2);
			}
			else if(input>=21&&input<=40){
				printf("%d\n",80+(input-20)*1);
			}
			else if(input>=40){
				printf("%d\n",100);
			}
	}
	return 0;	
} 
