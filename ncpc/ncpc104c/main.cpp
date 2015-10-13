#include<iostream>
#include<cstring>
#include<stdio.h>
using namespace std;

int main(){
    int stu[10001][13]={};
    int order[10]={};
    int rank[10001]={};
    int maxn=1000;
    int num=0;
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
                        stu[i][k+1]+=1;
                    }
                    else if(stu[i][j]<a&&stu[i][j]>=b){
                        stu[i][k+2]+=1;
                    }
                }
            }
            for(int i=0;i<n;++i){
                int max=i;
                for(int j=i+1;j<k;++j){
                    if(stu[max][k+1]<stu[rank[j]][k+1]||(stu[max][k+1]==stu[rank[j]][k+1]&&stu[max][k+2]<stu[j][k+2])){
                        max=j;
                        printf("max %d",max);
                    }
                }
                for(int i=0;i<n;++i){

                printf("%d-",rank[i]);

                }
                printf("\n");
                int temp=rank[i];
                rank[i]=rank[max];
                rank[max]=temp;//swap

            }
            int value=0,same=0;
            for(int i=0;i<n;++i){
                if(stu[rank[i]][k+1]==stu[rank[i+1]][k+1]&&stu[rank[i]][k+2]==stu[rank[i+1]][k+2]){
                    stu[rank[i]][k]=stu[rank[i+1]][k]=value;
                    same+=2;
                    i++;
                }
                else{
                    value+=same;
                    stu[i][k]=value;
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
