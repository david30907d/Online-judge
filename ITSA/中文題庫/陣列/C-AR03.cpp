#include <iostream>
using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int power(short arr);
int main(int argc, char** argv) {
	short arr[6]={};
	while((cin>>arr[0])!=0){
		
		int sum=0;
		sum=power(arr[0]);
		int powerval=0;
		for(short i=1;i<=5;i++){
			cin>>arr[i];
			powerval=power(arr[i]);
			sum+=powerval;
		}
		cout<<sum<<"\n";
	}
	return 0;
}
int power(short arr){
	int sum=1;
	for(short i=0;i<=2;i++){
		sum*=arr;
	}
	return sum;
}
