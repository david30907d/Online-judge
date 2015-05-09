#include<cstdio>
#include<cstring>
#include<cctype>
#include<algorithm>
using namespace std;
int main(){
	int people=0,hat=0;	
	while(scanf("%d %d",&people,&hat)!=EOF){
		if(people>hat){
			printf("%d\n",hat+1);
		}		
		else{
				printf("%d\n",hat);
		}
	
	}
	return 0; 
}

