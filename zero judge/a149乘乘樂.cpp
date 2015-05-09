#include<cstdio>
#include<cstring>
#include<cctype>
#include<algorithm>
using namespace std;
int main(){		
	int num=0;	
	int input=0;
	int sum=1;
	while(scanf("%d",&num)!=EOF){		
		for(int i=0;i<num;i++){
			sum=1;
			scanf("%d",&input);
			if(input==0){
				sum=0;
			}
			while(input!=0){
				sum=sum*(input%10);
				input/=10;
			}			
			printf("%d\n",sum);
		}
		
	}
	return 0; 
}

