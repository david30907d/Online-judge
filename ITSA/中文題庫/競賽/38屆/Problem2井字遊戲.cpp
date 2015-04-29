#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main(int argc,char *argv[]){
	int input[3][3];
	char answer[3][3];
	while(scanf("%d",&input[0][0])!=EOF){
		int i=1,j=0;
		for(i=1;i<=2;i++){
			scanf("%d",&input[0][i]);
		}
		for(i=1;i<=2;i++){
			for(j=0;j<=2;j++){
				scanf("%d",&input[i][j]);
			}
		}//到此輸入結束
		
		for(i=0;i<=2;i++){
			for(j=0;j<=2;j++){
				if(input[i][j]==0){
					answer[i][j]='*';
				}
				else if(input[i][j]==1){
					answer[i][j]='Y';
				} 
				else{
					answer[i][j]='X';
				}
				
			}
		}
		//這裡是輸出 
		for(i=0;i<=2;i++){
			for(j=0;j<=2;j++){
				printf("%c",answer[i][j]);
			}
			printf("\n");
		}
		for(j=0;j<=2;j++){
	
			if(answer[0][j]==answer[1][j]&&answer[0][j]==answer[2][j]){
				if(answer[0][j]=='Y'){
					printf("Y bingle\n");
				}
				else if(answer[0][j]=='X'){
					printf("X bingle\n");
				}
				else{
					printf("tie\n");
				}
			}
		}
		for(i=0;i<=2;i++){
	
			if(answer[i][0]==answer[i][1]&&answer[i][0]==answer[i][2]){
				if(answer[i][0]=='Y'){
					printf("Y bingle\n");
				}
				else if(answer[i][0]=='X'){
					printf("X bingle\n");
				}
				else{
					printf("tie\n");
				}
			}
		}
		if((answer[1][1]==answer[0][0]&&answer[2][2]==answer[1][1])||(answer[1][1]==answer[0][2]&&answer[2][0]==answer[1][1])){
			if(answer[1][1]=='Y'){
				printf("Y bingle\n");
			}
			else if(answer[1][1]=='X'){
				printf("X bingle\n");
			}
			else {
				printf("tie\n");
			}
		}
		
		memset(input,0,sizeof(input));
		memset(answer,'0',sizeof(answer));
	}
	return 0;
} 
