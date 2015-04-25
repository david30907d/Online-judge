#include<cstdio>
#include<cstring>
#include<cctype>
int readint(){
	char c=getchar();//用字元組成一個int，增快速度 
	int num=0;
	while(isdigit(c)){
		num=num*10;
		num=num+c-'0';
		c=getchar();
	}
	return num;
}
int buffer[10];//因為int 最多10為，2^31-1，所以只要宣告10格 
int writeint(int num){
	int len=0;
	while(num>0){
		buffer[len++]=num%10;
		num/=10;
	}
	for(int i=len-1;i>=0;i--){
		putchar(buffer[i]+'0');//要逆著輸出 
	}
}
int main(){
	int time,age[101]={0};
	while(time=readint()){
		memset(age,0,sizeof(age));
		for(int i=1;i<=time;i++){
			age[readint()]++;//使用的是記數排序法 
		}
		int first=0;
		for(int i=1;i<=100;i++){
			for(int j=0;j<age[i];j++){
				if(first!=0){
					putchar(' ');//如果不是第一個的話前面就加空格 
					writeint(i);
				}
				else{
					writeint(i);
					first=1;
				}
			}
		}
		putchar('\n');
	}
	return 0; 
}
