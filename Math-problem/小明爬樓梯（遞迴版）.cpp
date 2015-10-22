#include<iostream>
#include<cstring>
#include<stdio.h>
using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int stairs[100003];
int current=4;
int build(int num);
int main(int argc, char** argv) {
	int test=0;
	stairs[1]=1;
	stairs[2]=2;
	stairs[3]=4;
	current=4;
	build(100000);
	scanf("%d",&test)	;
	for(int time=1;time<=test;time++){
		int input=0;
		long long int ans=0;
		scanf("%d",&input);
		printf("%d\n",stairs[input]);
	}
	return 0;
}
int build(int num){
    if(stairs[num]==0){
        stairs[num]=(((build(num-1)%10000000)+(build(num-2)%10000000)+(build(num-3)%10000000)%10000000));
    }
    if(num==3){
        return 4;
    }
    else if(num==2){
        return 2;
    }
    else if(num==1){
        return 1;
    }
    return stairs[num];
}

