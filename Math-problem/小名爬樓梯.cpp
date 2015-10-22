#include<iostream>
#include<cstring>
#include<stdio.h>
using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int stairs[100003];
int current=4;
void build();
int main(int argc, char** argv) {
	int test=0;
	stairs[1]=1;
	stairs[2]=2;
	stairs[3]=4;
	current=4;
	build();
	scanf("%d",&test)	;
	for(int time=1;time<=test;time++){
		int input=0;
		long long int ans=0;
		scanf("%d",&input);
		printf("%d\n",stairs[input]);
	}
	return 0;
}
void build(){
	for(int i=4;i<=10000;i++){
		stairs[i]=((stairs[i-1]%10000000)+(stairs[i-2]%10000000)+(stairs[i-3]%10000000)%10000000);
	}	
}
