#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argc, char *argv[]) {
	int arr[9][9]={};
	memset(arr,0,sizeof(arr));
	while(scanf("%d",&arr[0][0])!=EOF){//輸入地1個
		int i=1; 
		for(i=1;i<=8;i++){//輸入第一列第2到9個 
			scanf("%d",&arr[0][i]);
		}
		int row=0,col=0;
		for(row=1;row<=8;row++){
			for(col=0;col<=8;col++){
				scanf("%d",&arr[row][col]);
			}
		}//到此為止輸入結束，無錯誤
		int detect=0,counter=0;//detect是偵測到如果不隊就跳出去，1是錯 
		//counter試算每個數都只能出現一次 
		row=0,col=0;
		i=0;
		int numTime[9]={};
		for(row=0;row<=8;row++){
			for(col=0;col<=8;col++){
				for(i=1;i<=9;i++){//用來判斷他是1~9的哪一個數 
					if(arr[row][col]==i){
						if(numTime[i-1]==1){//代表在1列裡面以數字重複拉 
							detect=1;//1代表有錯 
							break;
						}
						numTime[i-1]=1;//如果確認這個數是多少就可以換下一個拉 
						break;
					}
				}
				if(detect==1){//有錯就一路跳出去 
					break;
				}
			}
			memset(numTime,0,sizeof(numTime));//再次把數字的計數器初始化 
			if(detect==1){//有錯就一路跳出去
				break;
			}
		}
		memset(numTime,0,sizeof(numTime));//再次把數字的計數器初始化
		if(detect!=1){//沒有錯誤才做第二種檢查 
			for(row=0;row<=8;row++){
				for(col=0;col<=8;col++){
					for(i=1;i<=9;i++){
						if(arr[col][row]==i){
							if(numTime[i-1]==1){//代表在1列裡面以數字重複拉 
								detect=1;//1代表有錯 
								break;
							}
							numTime[i-1]=1;//如果確認這個數是多少就可以換下一個拉 
							break;
						}
					}
					if(detect==1){//有錯就一路跳出去 
						break;
					}
				}
				memset(numTime,0,sizeof(numTime));//再次把數字的計數器初始化
				if(detect==1){//有錯就一路跳出去
					break;
				}
			}
		}
		if(detect!=1){
			int innerrow=0,innercol=0;
			for(row=0;row<=6;row=row+3){
				for(col=0;col<=6;col=col+3){
					memset(numTime,0,sizeof(numTime));//再次把數字的計數器初始化
					for(innerrow=0;innerrow<=2;innerrow++){//一次判斷一個3*3的正方型
						for(innercol=0;innercol<=2;innercol++){
							for(i=1;i<=9;i++){//用來判斷他是1~9的哪一個數 
								if(arr[innerrow][innercol]==i){
									if(numTime[i-1]==1){//代表在1列裡面以數字重複拉 
										detect=1;//1代表有錯 
										break;
									}
									numTime[i-1]=1;//如果確認這個數是多少就可以換下一個拉 
									break;
								}
							}
							if(detect==1){//有錯就一路跳出去 
								break;
							}
						}
						if(detect==1){//有錯就一路跳出去
							break;
						}
					}
					if(detect==1){
						break;
					}
				}
				if(detect==1){
					break;
				}
			}
		} 
		if(detect==1){
			printf("no\n");
		}
		else{
			printf("yes\n");	
		}
	}
	return 0;
}
