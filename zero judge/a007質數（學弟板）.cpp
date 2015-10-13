#include<iostream>
#include<cstdio>
#include<cmath>
using namespace std;
int sqr[46341]; //sqrt(2147483647) : 0,1 
int pri[5000];  //質數紀錄         : 數字 
int eq=2;    //紀錄46340以內的質數數量 


void prime();

int main()
{
	prime();
	int a;
	while(scanf("%d",&a)!=EOF)
	{
		if(a<=46340)        
		{
			if(sqr[a]==0) printf("非質數\n");
			else printf("質數\n");
		}
		else
		{
			int b=1;
			for(int i=0;i<eq;i++)
			{
				if(a%pri[i]==0) 
				{
					b=0;
					break;
				}
			}
			if(b==0) printf("非質數\n");
			else printf("質數\n");
		}
		
	}
	return 0;
 } 
 
 void prime()
 {
    pri[0]=2; pri[1]=3;
    
    for(int i=0;i<=46340;i++) sqr[i]=0;
    sqr[2]=1; sqr[3]=1;
 	for(int i=4;i<=46340;i++)
 	{
 		int k=1;
 		for(int j=0;pri[j]*pri[j]<=i;j++)
 		{
 			if(i%pri[j]==0)
 			{
 				k=0;
 				break;
			 }
		 }
		 if(k==1) 
		 {
		 	sqr[i]=1;
		 	pri[eq]=i;
		 	eq++;
		 }
 		
	 }
	

 }