#include<iostream>
#include<cmath>
#include<cstring>
#include<stdio.h>
using namespace std;
int main(){
	int change[26]={10,11,12,13,14,15,16,17,34,18,19,20,21,22,35,23,24,25,26,27,28,29,32,30,31,33};
	char id[10]={};
	while(scanf("%s",id)!=EOF){
		int i=0,j=0;
		int first=0;
		id[0]=toupper(id[0]);
		first=id[0]-'A';
		int answer=0;
		answer=(change[first]/10)+(change[first]%10)*9;//計算英文字母的數字和 
		int sum=0;
		sum=sum+answer+id[9]-'0';
		for(i=1,j=8;i<=8&&j>=1;i++,j--){
			sum=sum+j*(id[i]-'0');
		}	
		if(sum%10==0){
			printf("real\n");
		}
		else if(sum%10!=0){
			printf("fake\n");
		}
		
		
	}
	 	return 0;
}
