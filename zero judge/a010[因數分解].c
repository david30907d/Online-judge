#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int main(int argc, char *argv[]) {
	int input=0;
	while(scanf("%d",&input)!=EOF){
		int i,count=0;
		for(i=2;i*i<=input;i++){
			while(input%i==0){
				//會計算有幾個這種的因式
				//然後同步讓input變小
				count++;
				input=input/i;
			}
			if(count>1&&input>1){
				printf("%d^%d * ",i,count);
			}
			
			else if(count==1&&input>1){
				printf("%d * ",i);
			}
			else if(count>1&&input==1){
				printf("%d^%d\n",i,count);
			}
			else if(count==1&&input==1){
				printf("%d\n",i);
			}
			count=0;
		}
		if(input>1){
			//因為上面的判斷是指判斷到i^2 <= input
			//所以如果剩下的數為質數，就沒辦法被除盡,所以要在這邊把最後一個質數給印出來
			printf("%d\n",input);
		}
		
	}
	return 0;
}

