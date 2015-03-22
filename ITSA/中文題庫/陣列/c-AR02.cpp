#include <iostream>
using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main() {
	int input[6]={};
	int output[6]={};
	while(cin>>input[0]>>input[1]>>input[2]>>input[3]>>input[4]>>input[5]){
		int j=5;
		for(int i=0;i<=5;i++){
			output[j-i]=input[i];
		}
		for(int i=0;i<=5;i++){
			cout<<output[i]<<" ";
		}
	}
	return 0;
}
