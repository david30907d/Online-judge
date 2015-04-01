#include<iostream>
#include<cmath>
#include<cstring>
#include<stdio.h>
using namespace std;
int main(){
	char input[1000];
	while(scanf("%s",input)!=EOF){
		int length=strlen(input);
		int check=1;
		for(int i=0;i<=(length/2)-1;i++){
			if(input[i]==input[length-i-1]){
				check=1;
			}
			else{
				check=0;
				break;
			}
		}
		if(check==0){
			printf("no\n");
		}
		else{
			printf("yes\n");
		}
	}
	 	return 0;
}
