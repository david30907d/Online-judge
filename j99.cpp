#include <stdio.h>
#include <stdlib.h>


int main(int argc, char *argv[]) 
{
	int test;
	while(scanf("%d",&test)!=EOF)
	{
		while(test>0)
		{
			int station,first_s,first_m;
			scanf("%d %d %d",&station,&first_s,&first_m);
			int connect,i;
			int c[100000][3];
			scanf("%d",&connect);
			for(i=0;i<connect;i++)
			{
				scanf("%d %d %d",&c[i][0],&c[i][1],&c[i][2]);
			}
			int money,dollar[40][2];
			scanf("%d",&money);
			for(i=0;i<money;i++)
			{
				scanf("%d %d",&dollar[i][0],&dollar[i][1]);
			}
			int ans[40][2],DO[40];
			ans[first_s][0]=1;
			ans[first_s][1]=first_m;
			DO[0]=2;
			for(i=0;i<=station;i++)
			{
				DO[i]=1;
			}
			int m,k,target,earn,end=0,cnt=0;
			for(m=first_s;m<station;m++)
			{
				end=0;
				if(ans[m][0]==1)
				{
					DO[m]=2;
					target=m;
					first_m=ans[m][1];
					for(i=0;i<connect;i++)
					{
						if(c[i][0]==target||c[i][1]==target&&first_m>=c[i][2])
						{
							earn=0;
							if(c[i][0]==target)
							{
								ans[c[i][1]][0]=1;
								for(k=0;k<money;k++)
								{
									if(dollar[k][0]==c[i][1])
									{
										earn=dollar[k][1];
										break;
									}
								}
								if(ans[c[i][1]][1]<first_m-c[i][2]+earn)
								{
									ans[c[i][1]][1]=first_m-c[i][2]+earn;
									DO[c[i][1]]=0;
								}
							}
							else
							{
								ans[c[i][0]][0]=1;
								for(k=0;k<money;k++)
								{
									if(dollar[k][0]==c[i][0])
									{
										earn=dollar[k][1];
										break;
									}
								}
								if(ans[c[i][0]][1]<first_m-c[i][2]+earn)
								{
									ans[c[i][0]][1]=first_m-c[i][2]+earn;
									DO[c[i][0]]=1;
								}
							}
						}
						
					}
				}
				for(k=0;k<station;k++)
				{
					if(DO[k]==1&&ans[k][0]==1)
					{
						m=DO[k]-1;
						end=1;
					}
				}
				if(end==0)
				{
					break;
				}
			}
			for(i=0;i<station;i++)
			{
				if(ans[i][0]==0)
				{
					cnt++;
				}
			}
			printf("%d",cnt);
			test--;
		}
	}
	return 0;
}
