#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include<ctype.h>

int main(int argc, char *argv[]) {
	int v=0,t=0;
	while(scanf("%d %d",&v,&t)!=EOF){
		int finalD=0;
		finalD=v*t*2;
		printf("%d\n",finalD);
	}
	return 0;
}

