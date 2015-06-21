#include<iostream>
#include<cstring>
#include<stdio.h>
using namespace std;
int main(){
	char input[10001]={};
	while(scanf("%s",input)!=EOF){
		char checks[10001]={};
		int counter=0;
		for(int i=0;i<strlen(input);i++){
			if((input[i]<=90&&input[i]>=65)||(input[i]>=97&&input[i]<=122)){
				checks[counter]=input[i];
				counter++;
			}
		}//到此為止已經處理好只有文字的字串了
		int len=strlen(checks);
		bool seqcheck=true;//seqcheck是檢查她排序後有沒有辦法變成回文 
		int count[52]={};
		int cal=0;//拿來做acsii運算的int 
		for(int i=0;i<strlen(checks);i++){//把他們都填到陣列哩，和計數排序法有點像 
			if(checks[i]<=90){
				cal=checks[i]-65;
				count[cal]++;
			}
			else{
				cal=checks[i]-97;
				count[cal]++;
			}
		}
		int count_odd=0;//用來計算有幾個字母是奇數的，因為回文就只能有一個奇數 
		for(int i=0;i<52;i++){
			if(count[i]%2!=0){
				count_odd++;
			}
			if(count_odd>1){
				printf("no...\n");
				seqcheck=false;
				break;
			}
		}
		if(seqcheck){
			printf("yes !\n");
		}
	}
	return 0;	
} 
