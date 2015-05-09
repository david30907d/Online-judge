#include<cstdio>
#include<cstring>
#include<cctype>
#include<algorithm>
using namespace std;
int main(){
	int arr[1000]={0};	
	int num=0;	
	while(scanf("%d",&num)){
		if(num!=0){
			for(int i=1;i<num;i++){
				if(i%7!=0&&i==1){
					printf("%d",i);
				}
				else if(i%7!=0){
					printf(" %d",i);
				}				
			}
		}
		else{
			break;
		}
		printf("\n");		
	}
	return 0; 
}

