#include<cstdio>
#include<cstring>
#include<cctype>
#include<algorithm>
using namespace std;
int arr[100000],time,num;//time是要做幾次，num是那一組要輸入幾個數字 
int main(){
	scanf("%d",&time);
	while(time>0){
		scanf("%d",&num);
		int i=0;
		for(i=0;i<num;i++){
			scanf("%d",&arr[i]);
		}
		int maxai=arr[0];
		int answer=arr[0]-arr[1];
		for(i=1;i<num;i++){
			answer=max(answer,maxai-arr[i]);//維護最大的maxai資訊
			maxai=max(arr[i],maxai);//找maxai-a[i]的差值為最大
		}
		printf("%d\n",answer);
		time--;
	}
	return 0; 
}
