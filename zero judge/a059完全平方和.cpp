#include<cstdio>
#include<cstring>
#include<cctype>
#include<algorithm>
using namespace std;
int sqseries[34]={};
int square(){
	int i=0;
	while(i<=33){
		sqseries[i]=(i+1)*(i+1);
		i++;	
	}	
}
int main(){
	int input=0;	
	square();
	while(scanf("%d",&input)!=EOF){
		int num1=0,num2=0;
		int counter=0;
		for(int i=1;i<=input;i++){
			scanf("%d%d",&num1,&num2);
			int index=0;//用來表示第幾個陣列的值是在num1 and num2之間 
			int sum=0;
			while(sqseries[index]<num1){
				index++;//index會剛好>=num1 
			}
			while(sqseries[index]<=num2){
				sum=sum+sqseries[index];
				index++;
			}
			printf("Case %d: %d\n",++counter,sum);
		}		
	}
	return 0; 
}
