 #include <stdio.h>
    #include <string.h>


    int main()
    {
        int i,j,l;
        char str[10000];
        while(gets(str)!=0)
        {
            char sign;
            int row;
            l=strlen(str);
            scanf("%c",&sign);
            scanf("%d",&row);
            for(i=0;i<row;i++)
            {
                for(j=l-row+i;j>=i;j-=row)
                {
                    if(j!=i)
                    {
                        printf("%c%c",str[j],sign);
                    }
                    else
                    {
                        printf("%c\n",str[j]);
                    }
                }
            }
			
        }
        return 0;
    }
