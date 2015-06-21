#include<cstdio>
#include<cstring>
#include<cctype>
#include<algorithm>
using namespace std;
int main(){
	int input=0;
	int num=0;
	int index=0;
	int cnt0=0;
	int cnt1=0;
	int cnt2=0;
	while(scanf("%d",&input)!=EOF){
		for(int i=1;i<=input;i++){
			scanf("%d",&num);
			if(num%3==0){
				cnt0++;
			}
			else if(num%3==1){
				cnt1++;
			}
			else{
				cnt2++;
			}
		}
		printf("%d %d %d\n",cnt0,cnt1,cnt2);
		cnt0=0;
		cnt1=0;
		cnt2=0;
	}
	return 0; 
}
