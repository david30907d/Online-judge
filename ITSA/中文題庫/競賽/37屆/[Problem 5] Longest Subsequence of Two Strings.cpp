#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argc, char** argv) {
	char first[20];
	char second[20];
	while(scanf("%s",first)!=EOF){
		int max=0,tempCounter=0;
		fflush(stdin);
		scanf("%s",second);
		int i,j,k;
		int index=0;//用來表示我比到第幾個字了，因為假設當我選擇
		//了第二字串的第二個字時
		//，下次就只能從三開始看，index是下一次的起始值 
		int jumpOff=0;
		for(i=0;i<=strlen(first)-1;i++){
			for(jumpOff=0;jumpOff<=strlen(first)-2;jumpOff++){//用來跑他每
			//一次要跳過first字串的第幾個數，被跳過的那個數不拿來比較，
			//這會是一種新的可能 
				for(j=i;j<=strlen(first)-1;j++){
					if(index>strlen(second)-1){
						break;
					}
					if(j!=jumpOff||j==i){//如果j不等於我要跳過的數jumpOff或
										//等於抓到的字串第一個字i就可以逕行判斷 
						for(k=index;k<=strlen(second)-1;k++){
							if(first[j]==second[k]){
								tempCounter++;
								index=k+1;
								break;
							}
						}
					}
					
				}
				if(tempCounter>max){
					max=tempCounter;//上面組存的暫時性最大字串數拿來跟MAX比較  
				}
				tempCounter=0;//把計算最大字串的數歸零 
				index=0;//在這邊把表示第二字串位置的index歸零
			}
		}
		printf("%d\n",max);	
	}
	return 0;	
} 
