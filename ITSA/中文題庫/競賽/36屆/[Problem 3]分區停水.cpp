#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int alreadycheck(int index,int counter,int *arr,int num);
int main(int argc, char *argv[]){
	int time=0;
	while(scanf("%d",&time)!=EOF){
		while(time>0){
			int num=0;
			scanf("%d",&num);
			int arr[num];
			memset(arr,0,sizeof(arr));//0表示沒停過水 
			int index=0;
			int counter=0;
			int max=0;//用來記最大數的停水位置 
			int j=0;
			for(j=0;j<num;j++){//初始的停水位置 
				index=j;//停水位置
				counter=j+1;
				arr[index]=1;//1表示停過水了
				int i=0;
				for(i=0;i<=num-1;i++){//單純給他做num-1次，
				//因為第一個停水的那次已經在上兩行做過了 
					if(arr[num-1]==1){//如果最後一個Arr為一(停過水)，就該結束 
						if(i==num-1){
							max=j;
							break;
						}
						else{
							break;
						}
					}
					index=alreadycheck(index,counter,arr,num);
					arr[index]=1;
				}
				memset(arr,0,sizeof(arr));//在一次初始化arr 
			}
			printf("%d\n",max+1);//答案 
			time--;
		}
	}
	
	return 0;
}
int alreadycheck(int index,int counter,int *arr,int num){//用來判斷那區停過水沒 
	while(counter>0){
		if(arr[index]==1||counter>0){
			index++;
			if(index>num-1){//代表index爆掉了 
				index=index-num;
			} 
		}
		if(arr[index]==0){
			counter--;
		}
	}
	return index;
}
