#include<iostream>
#include<cmath>
#include<cstring>
#include<stdio.h>
using namespace std;
int main(){
	char input[1000];
	char answer[1000]={};
	while(scanf("%s",input)!=EOF){
		int length=strlen(input);
		int i=0,j=0;
		for(i=length-1,j=0;i>=0;i--,j++){
			if((input[i]=='0'&&i==0)||(input[i]=='0'&&i==length-1)){
				continue;
			}
			else{
				answer[j]=input[i];
				//printf("%c",input[i]);
			}
		}
		for(i=0;i<strlen(answer);i++){
			printf("%c",answer[i]);
		}
		/*
		i=0;
		while(input[i]=='0'){
			i++;
		}
		
		
		for(j=strlen(answer)-1;j>=i;j--){
			if(answer[j]!='0'){
				break;
			}
			else{
				answer[j]='!';//把不要輸出的令成!這種符號 
			}
		}
		printf("%c%c%c%c%c%c",answer[4],answer[5],answer[6],answer[7],answer[8]);
		/*
		while(answer[i]!='!'){
			printf("%c",answer[i]);
			i++;
		}
		printf("\n");*/
	}
	return 0;
} 
