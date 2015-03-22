#include <stdio.h>
#include <stdlib.h>
int main(int argc, char** argv) {
	int num=0;
	while(scanf("%d",&num)!=EOF){ 
		int i;
		for(i=1;i<=num;i++){//會重複做NUM次，也就是NUM個圖形
			int row=0,column=0;
			scanf("%d %d",&row,&column);
			
			int graph[row][column];//宣告陣列
			int j=0;
			for(j=0;j<=row-1;j++){
				for(int k=0;k<=column-1;k++){
					scanf("%d",&graph[j][k]);
				}
			}//到此陣列都書玩了 
			int l=0,m=0;
			for(l=0;l<=row-1;l++){
				for(m=0;m<=column-1;m++){
						if(graph[l][m]==0){
							printf("_ ");
							
						}
						else{
							if(l>0&&graph[l-1][m]==0){
								printf("0 ");
					
							}	
							else if(l<row-1&&graph[l+1][m]==0){
								printf("0 ");
							}
							else if(m>0&&graph[l][m-1]==0){
								printf("0 ");
							}
							else if(m<column-1&&graph[l][m+1]==0){
								printf("0 "); 
							}
							else {
								printf("_ ");
								
							}
						} 
				}
				printf("\n");
			}
			if(i!=num){
				printf("\n");
			}
		}//輸出的for loop
	}
	return 0;
}	
	


