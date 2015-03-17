#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int main(int argc, char *argv[]) {
	int input=0;
	while(scanf("%d",&input)!=EOF){
		int i,count=0;
		for(i=2;i<=input;i++){
			while(input%i==0){
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
		
	}
	return 0;
}

