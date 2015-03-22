#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argc, char** argv) {
	char inputS[100]={};
	while(gets(inputS)!=NULL){//輸入我的字串
			char inputS[100]={};
			float col=0;
			char sym;//輸入符號 
			scanf("%c",&sym); 
			int row=0;//輸入要幾列
			scanf("%d",&row);
			col=2.0*(strlen(inputS)/(float)row)-1;//這是在整除的情況下 
			int icol=0;//院來檢查是否乘除
			icol=2*(strlen(inputS)/row)-1;
			if(icol!=col){//代表不整除 
				col=2.0*((strlen(inputS)/row)+1)-1;
			}
			int finalcol=0;
			finalcol=(int)col;
			char graph[row][finalcol];
			memset(graph,'0',sizeof(graph));//先把GRAPH陣列給初始化為0 
			printf("\nrow:%d col:%d",row,col);
			int j=0;//輸出 
			for(j=0;j<strlen(inputS);j++){
				printf("%c",inputS[j]);
			}printf("\n");
			//到此陣列都輸完了
			j=0;
			int i=0;
			for(i=0;i<row;i++){
				for(j=0;j<finalcol;j++){
					printf("%c ",graph[i][j]);
					
				}
				printf("%d",i);
				printf("\n");
			}
			
			printf("\n");
	}
	
	return 0;
}
