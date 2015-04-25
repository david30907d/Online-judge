#include<iostream>
#include<cstring>
#include<stdio.h>
using namespace std;
int main(){
	int input=0;
	int answer=0;
	int i=0;
	while(cin>>input){
		answer=2*input;
		if(input<2){
			cout<<answer<<endl;
		}
		else{
			for(i=2;i<=input;i++){
				answer=answer+i*(input-i);
			}
			cout<<answer<<endl;
		}
	}
	return 0;	
} 
