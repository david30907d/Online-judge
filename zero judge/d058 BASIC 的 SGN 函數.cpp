#include<cstdio>
#include<cstring>
#include<cctype>
#include<algorithm>
using namespace std;
int dragon[20000],knight[20000]; 
int main(){
	int input=0;
	while(scanf("%d",&input)!=EOF){
		printf("%d\n",(input>0)-(input<0));
	}
	return 0; 
}
