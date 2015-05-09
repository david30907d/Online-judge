#include<cstdio>
#include<cstring>
#include<cctype>
#include<algorithm>
using namespace std;
int main(){
	char input[8]={};
	int answer[6]={0};	
	while(scanf("%s",input)!=EOF){		
		for(int i=0;i<=5;i++){
			if((input[i]-input[i+1])>=0){
				answer[i]=input[i]-input[i+1];
			}
			else{
				answer[i]=input[i+1]-input[i];
			}
		}
		for(int i=0;i<=5;i++){
			printf("%d",answer[i]);
		}
		printf("\n");
	}
	return 0; 
}

