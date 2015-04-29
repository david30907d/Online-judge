#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main(int argc,char *argv[]){
	int input[22][22]={0};
	int time=0;
	while(scanf("%d",&time)!=EOF){
		while(time>0){
			memset(input,0,sizeof(input));//原始設為0 芬過糖果為1 
			int col,row;
			scanf("%d",&col);
			scanf("%d",&row);//輸入行 列 
			int i=0,j=0;
			/*
			for(i=1;i<=row;i++){
				for(j=1;j<=col;j++){
					scanf("%d",&input[row][col]);
				}
			}//輸入*/
			int bags=0;//糖果代數 
			scanf("%d",&bags);
			int x,y;
			for(i=1;i<=bags;i++){//把糖果分出去，分到為1 
				scanf("%d",&x);
				scanf("%d",&y);
				input[y+1][x]=1;
				input[y-1][x]=1;
				input[y][x+1]=1;
				input[y][x-1]=1;
			}
			int check=1;
			for(i=1;i<=row;i++){
				if(check!=1)break;
				for(j=1;j<=col;j++){
					if(input[i][j]!=1){
						check=0;
						break;
					} 
				}
			}
			if(check!=1){
				printf("N\n");
			}
			else{
				printf("Y\n");
			}
			
			time--;
		}
		
	}
	return 0;
} 
