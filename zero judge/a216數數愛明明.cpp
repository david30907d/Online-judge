#include<iostream>
#include<cstring>
#include<stdio.h>
using namespace std;
unsigned long long int f[30000]={},g[30000]={};
int build_f(){
	f[0]=1;
	for(int i=1;i<=29999;i++){
		f[i]=(i+1)+f[i-1];
	}
}
int build_g(){
	g[0]=1;
	for(int i=1;i<=29999;i++){
		g[i]=f[i]+g[i-1];
	}
}
int main(){
	int day=0;
	build_f();
	build_g();
	while(scanf("%d",&day)!=EOF){		
		printf("%llu %llu\n",f[day-1],g[day-1]);
	}
	return 0;	
} 


