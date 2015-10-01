#include<iostream>
#include<cstring>
#include<stdio.h>
using namespace std;
int main(){
	int num,input,age[101];
	while((scanf("%d",&num)==1)&&num){//scanf必須要成功輸入且num不能=0 
		memset(age,0,sizeof(age));
		for(int i=0;i<num;i++){
			scanf("%d",&input);
			age[input]++;//age[]的數字代表那個年齡的次數 
		}
		int first=1;//旗標first=1表示沒有輸出過整數
		for(int i=1;i<100;i++){
			for(int j=1;j<=age[i];j++){
				if(!first){
					printf(" ");
				}
				first=0;
				printf("%d",i);
			}
		} 
		cout<<endl;
	}
	
	
	return 0;
}
