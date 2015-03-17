#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include<ctype.h>

int main(int argc, char *argv[]) {
	int row=0,col=0;
	int max=0;
	while(scanf("%d %d",&row,&col)!=EOF){
		if(row>col){
			max=row;
		}
		else{
			max=col;
		}
		int arr[max][max];
		memset(arr,0,sizeof(arr));
		int i=0,j=0;
		for(i=0;i<=row-1;i++){
			for(j=0;j<=col-1;j++){
				scanf("%d",&arr[i][j]);
			}
			
		}
		int temp=0;
		i=0,j=0;
		int index=0;
		for(i=0;i<=row-1;i++){
			for(j=index;j<=col-1;j++){
				temp=arr[i][j];
				arr[i][j]=arr[j][i];
				arr[j][i]=temp;
			}
			if(col>1){
				index++;
			}
			else{
				index=0;
			}
		}
		i=0;j=0;
		for(i=0;i<=col-1;i++){
			for(j=0;j<=row-1;j++){
				printf("%d ",arr[i][j]);
			}
			printf("\n");
		}
	}
	return 0;
}

