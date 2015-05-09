#include<cstdio>
#include<cstring>
#include<cctype>
#include<algorithm>
using namespace std;
int main(){
	int arr[1000]={0};	
	int num=0;	
	while(scanf("%d",&num)!=EOF){
		for(int i=0;i<num;i++){
			scanf("%d",&arr[i]);
		}
		sort(arr,arr+num);
		for(int i=0;i<num;i++){
			if(i==0){
				printf("%d",arr[i]);
			}
			else {
				printf(" %d",arr[i]);
			}			
		}	
		printf("\n");		
	}
	return 0; 
}

