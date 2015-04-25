#include<iostream>
#include<cmath>
#include<cstring>
#include<stdio.h>
using namespace std;
int main(){
	int input=0;
	int a=0;
	while(cin>>input){
		a=0;
		while(input>0){
			a=a*10;
			a=a+input%10;
			input=input/10;
		}
		cout<<a<<endl;
	}
	return 0;
} 
