#include<iostream>
#include<cstring>
#include<stdio.h>
using namespace std;
int main(){
	long long int input=0;
	int s=0;
	long long int x=0,y=0;
	while(scanf("%d",&input)!=EOF){
		while(input>0){
			scanf("%d %lld %lld",&s,&x,&y);
			if(s==1){
				printf("%lld\n",x+y);
			}
			else if(s==2){
				printf("%lld\n",x-y);
			}
			else if(s==3){
				printf("%lld\n",x*y);
			}
			else if(s==4){
				printf("%lld\n",x/y);
			}
			input--;
		}
	}
	return 0;	
} 
