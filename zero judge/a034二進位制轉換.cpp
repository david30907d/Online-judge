#include<iostream>
#include<cmath>
#include<cstring>
#include<stdio.h>
using namespace std;
int main(){
	int input=0;
	int output[100]={0};
	while(scanf("%d",&input)!=EOF){
		int cal=input;
		int cnt=0;
		int i=0;
		for(i=1,cnt=0;i<=input;i=i*2,cnt++){
			output[cnt]=cal%2;
			cal=cal/2;
		}
		cout<<endl;
		for(i=cnt-1;i>=0;i--){
			printf("%d",output[i]);
		}
		cout<<endl;
	}
	 	return 0;
}
