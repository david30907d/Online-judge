#include<iostream>
#include<cstring>
#include<stdio.h>
using namespace std;
int stu[10001][13]={};
    int order[10]={};
    int rank[10001]={};
    int maxn=1000;
    int num=0;
int main(){    
    for(int i=0;i<=10000;++i){
        rank[i]=i;
    }
    while(scanf("%d",&num)!=EOF){
        for(int count=1;count<=num;++count){
            int n,s,k,m,a,b;
            //fflush(stdin);
            scanf("%d",&n);
            scanf("%d",&s);
            scanf("%d",&k);
            scanf("%d",&m);
            scanf("%d",&a);
            scanf("%d",&b);
            for(int i=0;i<=9;++i){
                   memset(stu[i],0,10*sizeof(int));
                   //全部填為0
            }
            for(int i=0;i<n;++i){
                for(int j=0;j<k;++j){
                    scanf("%d",&stu[i][j]);
                }
            }
            for(int i=0;i<s;++i){
                scanf("%d",&order[i]);
            }               
            for(int i=0;i<n;++i){
                for(int j=0;j<k;++j){
                    if(stu[i][j]==m||stu[i][j]>=a){                        
                        //if(j>1){
                        //    printf("A:%d %d\n",stu[i][j],stu[i][k+1]);
                        //}
                        stu[i][k+1]+=1;                        
                        
                    }
                    else if(stu[i][j]<a&&stu[i][j]>=b){
                        stu[i][k+2]+=1;
                        //if(i==0){
                        //    printf("B:%d\n",stu[i][k+2]);
                        //}
                    }
                }
            }
            for(int i=0;i<n;++i){
            	//rank裡面是用來存我排序後的student，裡面的數字代表student輸入的順序
                int max=i;
                for(int j=i+1;j<n;++j){
                    if(stu[rank[max]][k+1]<stu[rank[j]][k+1]||(stu[max][k+1]==stu[rank[j]][k+1]&&stu[max][k+2]<stu[rank[j]][k+2])){
                    	//排序要檢查兩個條件:A的數量比B優先
                        max=j;                        
                    }
                }                
                int temp=rank[i];
                rank[i]=rank[max];
                rank[max]=temp;//swap                
            }
            int value=0,same=0;
            for(int i=0;i<n;++i){
                if(i==0&&stu[rank[i]][k+1]==stu[rank[i+1]][k+1]&&stu[rank[i]][k+2]==stu[rank[i+1]][k+2]){
                	//第一個student不用檢查比他前面的學生
                	//如果相同就same+2，並且跳到下下一個學生
                    stu[rank[i]][k]=value;
                    stu[rank[i+1]][k]=stu[rank[i]][k];
                    same+=2;
                    i++;
                }
                else if(i!=0&&stu[rank[i]][k+1]==stu[rank[i+1]][k+1]&&stu[rank[i]][k+2]==stu[rank[i+1]][k+2]&&stu[rank[i]][k+2]!=stu[rank[i-1]][k+2]&&stu[rank[i]][k+1]!=stu[rank[i-1]][k+1]){
                	//如果不是第一個學生那就要比較是不是跟前一位學生一樣囉
                	//這個情況是不一樣的
                	value+=same;
                	same=0;
					stu[rank[i]][k]=value;
                    stu[rank[i+1]][k]=stu[rank[i]][k];
                    same+=2;
                    i++;				
				} 
				else if(i!=0&&stu[rank[i]][k+1]==stu[rank[i+1]][k+1]&&stu[rank[i]][k+2]==stu[rank[i+1]][k+2]&&stu[rank[i]][k+2]==stu[rank[i-1]][k+2]&&stu[rank[i]][k+1]==stu[
					rank[i-1]][k+1]){
					//這個情況是一樣的(跟前一位的數據一樣)
					stu[rank[i]][k]=value;
                    stu[rank[i+1]][k]=stu[rank[i]][k];
                    same+=2;
                    i++;				
				}
                else{
                	//沒有相同就把先前有相同排名所累積的same給加上去
                	//然後value++;
                    value+=same;
                    same=0;
                    stu[rank[i]][k]=value;
                    value++;
                }
            }                        
            for(int i=0;i<s;++i){
                if(i==0){
                    printf("%d",stu[order[i]-1][k]);
                }
                else{
                    printf(" %d",stu[order[i]-1][k]);
                }
            }
            printf("\n");
        }
    }
    return 0;
}
