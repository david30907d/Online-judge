#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) 
{
    int a;
    while(scanf("%d",&a)!=EOF)
    {
        while(a>0)
        {
            int n,m,p,max,i,j,k;
            int matrix1[100][100],matrix2[100][100],ans[100][100]={0};
            scanf("%d %d %d",&n,&m,&p);
            for(i=0;i<n;i++)
            {
                for(j=0;j<m;j++)
                {
                    scanf("%d",&matrix1[i][j]);
                }
            }
            for(i=0;i<m;i++)
            {
                for(j=0;j<p;j++)
                {
                    scanf("%d",&matrix2[i][j]);
                }
            }
            for(i=0;i<n;i++)
            {
                for(j=0;j<p;j++)
                {
                    for(k=0;k<m;k++)
                    {
                        ans[i][j]+=matrix1[i][k]*matrix2[k][j];
                    }
                    if(i==0&&j==0)
                    {
                        max=ans[i][j];
                    }
                    else
                    {
                        if(max<ans[i][j])
                        {
                            max=ans[i][j];
                        }
                    }
                }
            }
            printf("%d\n",max);
            a--;
        }
    }
    return 0;
}
