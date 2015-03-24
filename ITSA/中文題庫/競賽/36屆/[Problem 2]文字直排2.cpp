#include <stdio.h>
    #include <stdlib.h>
    #include <string.h>
    /* run this program using the console pauser or add your own getch, system("pause") or input loop */

    int main(int argc, char *argv[])
    {
     char str[100];
     while(gets(str)!=NULL){
        int row,l,i,j,k;
        char sign;
         scanf("%c %d",&sign,&row);
         l=strlen(str);
         k=l/row;
           if(l%row==0)
           {
              for(i=0;i<row;i++)
              {
                  for(j=(k-1)*row+i;j>=i;j-=row)
                  {
                      printf("%c",str[j]);
                      if(j!=i)
                      {
                	      printf("%c",sign);
                      }
                  }
                  printf("\n");
              }
          }
          else
           {
              for(i=0;i<row;i++)
              {
                  for(j=k*row+i;j>=i;j-=row)
                  {
                      if(j<l)
                     {
                          printf("%c",str[j]);
                       }
                      if(j>=l)
                       {
                          printf(" ");
                       }
                      if(j!=i)
                       {
                          printf("%c",sign);
                     }
                  }
                  printf("\n");
              }
          }
          fflush(stdin);

    }
      return 0;
    }
