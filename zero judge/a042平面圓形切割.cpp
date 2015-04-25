#include<iostream>
#include<cstring>
#include<stdio.h>
using namespace std;
int main(){
	int input=0;
	int answer=0;
	while(cin>>input){
		answer=2+input*input-input;
		cout<<answer<<endl;
	}
	return 0;	
}

