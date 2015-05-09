#include<cstdio>
#include<cstring>
#include<cctype>
#include<algorithm>
using namespace std;
int main(){	
	double arr[1000]={0};
	int num=0;	
	while(scanf("%d",&num)!=EOF){
		for(int i=0;i<num;i++){
			scanf("%lf",&arr[i]);
		}
		double sum=0;
		for(int i=0;i<num;i++){
			sum=sum+arr[i];
		}
		double ave=sum/num;		
		if(ave>59){
			printf("no\n");
		}
		else{
			printf("yes\n");
		}
	}
	return 0; 
}

