#include <stdio.h>
#include <stdlib.h>
int main(int argc, char *argv[]) {
	int num;
	while(scanf("%d",&num)!=EOF){
		while(num>0){
		fflush(stdin);
		int input[100]={};//時間表的陣列 
		int j,i=0;
		while(scanf("%d",&input[i])==1){
			if(input[i]==0){//0就是時間表的結尾 
				break;
			}
			//fflush(stdin);加了就不能用空格輸入，我也不知為啥 
			i++;
		}
		int k=0,min=0,temp;//這段是排序法 
		for(j=1;j<i-1;j++){
			min=j;
			for(k=j+1;k<i;k++){
				if(input[k]<input[min]){
					min=k;
				}
			}
			temp=input[j];
			input[j]=input[min];
			input[min]=temp;
		}
		int sum=0,counter=1;//判斷:若超過時間限制或表演數已經跟時間表上表演的隊伍一樣多當然就樣停了 
		while(sum<=input[0]&&counter<=i-1){
			sum=sum+input[counter];
			if(counter==(i-1)&&sum<=input[0]){ 
				break;
			}
			else if(counter==(i-1)&&sum>input[0]){
				counter--;
				break;
			}
			else if(counter<(i-1)&&sum>input[0]){
				counter--;
				break;
			}
			else if(counter<(i-1)&&sum==input[0]){
				break;
			}
			counter++;
			
		}
		printf("%d\n",counter);
		num--;//控制我能輸入幾次時間表 
		}
	}
	return 0;	
}
