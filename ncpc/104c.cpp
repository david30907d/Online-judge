#include<iostream>
#include<cstring>
#include<stdio.h>
using namespace std;
int stu[][]={};
int order[]={};
int rank[]={};
int maxn=1000;
int main(){
    while(cin.hasNext()){
        int num=cin.nextInt();
        for(int count=1;count<=num;++count){
            int n=cin.nextInt(),s=cin.nextInt(),k=cin.nextInt(),m=cin.nextInt(),a=cin.nextInt(),b=cin.nextInt();
            for(int i=0;i<n;++i){
                for(int j=0;j<k;++j){
                    stu[i][j]=cin.nextInt();
                }
            }
            for(int i=0;i<s;++i){
                order[i]=cin.nextInt();
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
                    }
                }
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
                    System.out.print(stu[order[i]-1][k]);
                }
                else{
                    System.out.print(" "+stu[order[i]-1][k]);
                }
            }
            System.out.println();
        }
    }
    cin.close();
    return 0;
}


