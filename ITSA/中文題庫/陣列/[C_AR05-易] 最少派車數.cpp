#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argc, char *argv[]) {
	int input=0;
	while(scanf("%d",&input)!=EOF){
		int n=2*input;
		int timetable[n];//«Å§i2N­Ó°}¦C
		short i=0;
		for(i;i<n;i++){
			scanf("%d",&timetable[i]);
			fflush(stdin);
		} 
		i=0;
		for(i;i<n;i++){
			printf("%d ",timetable[i]);
		}
	}
	return 0;
}

