#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include<ctype.h>

int main(int argc, char *argv[]) {
	int input1=0;
	while(scanf("%d",&input1)!=EOF){
		int tele[10]={};
		int i=0;
		for(i;i<=9;i++){
			scanf("%d",&tele[i]);
			
		}
		i=0;
		for(i=0;i<=9;i++){
			tele[i]=10-(tele[i]-input1-48);
			if(tele[i]==10){
				tele[i]=0;
			}
		}
		i=0;
		
		for(i;i<=9;i++){
			if(i==9){
				printf("%d\n",tele[i]);//我想把10減掉(tele轉成%c後的結果)，可是不會ㄟ 
			}
			else{
				printf("%d",tele[i]);
			}
		}
		
	}
	return 0;
}

