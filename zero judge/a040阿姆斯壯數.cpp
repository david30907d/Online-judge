#include<cstdio>
#include<cstring>
#include<cctype>
#include<math.h>
int main(){
	int n1=0,n2=0;
	while(scanf("%d %d",&n1,&n2)!=EOF){	
		int counter=0;//用來記有幾個阿姆 	
		for(int i=n1;i<=n2;i++){			
			int num=0;
			int decimal=0;
			int sum=0;
			num=i;
			while(num>0){
				num=num/10;
				decimal++;
			}
			num=i;
			for(int j=1;j<=decimal;j++){
				sum=sum+pow(num%10,decimal);
				num=num/10;			
			}			
			if(sum==i){
				counter++;
				if(counter==1){
					printf("%d",i);
				}
				else{
					printf(" %d",i);
				}
			}							
		}		
		if(counter==0){
			printf("none\n");							
		}
		else{
			printf("\n");
		}
	}
	return 0; 
}
