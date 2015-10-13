#include <stdio.h>
#define MAX 100

long determinant(int m,int L[][MAX]); /* 算行列式的子程式 */
main()
{
   int i,j,ai,n; /* n:矩陣大小 */
   long ans;  /* ans:算出的行列式值 */
   int A[MAX][MAX];   /* A:所要求的矩陣 */
   char filename[10]; /* 資料檔的檔名 */
   FILE *fn;
   
   /*輸入矩陣資料所在的檔*/
   /*檔案格式為:         */
   /* n                  */
   /* X X X X   第一列   */
   /* X X X X   第二列   */
   /* X X X X     :      */
   /* X X X X     :      */
   /* n: 矩陣大小        */
   /* X: 矩陣元素        */
   printf("Please input the filename of data => ");
   scanf("%s",&filename); /* 讀入檔名 */ 
   if ((fn=fopen(filename,"r"))==NULL)
   {   
      printf("File open error!\n");
      exit(1);
   }
   else
   {
      /*讀入矩陣大小*/
      fscanf(fn,"%d",&n);
      /*讀入矩陣*/
      for (i=0;i<n;i++)
         for (j=0;j<n;j++)
            fscanf(fn,"%d",&A[i][j]); 
      /*呼叫算行列式值的函數*/
      ans=determinant(n,A);
      /*印出答案*/ 
      printf("detA= %d\n",ans);
   }
   fclose(fn);  /*關檔*/
}

long determinant(int m,int L[][MAX])
{
   int ai,i,j,temp[MAX][MAX];
   long ans=0,lans=0;

   if (m<=2)
   {
      /* 小於二(剩 2 X 2 的矩陣)時,直接算 L00*L11-L10*L01  */
      ans=L[0][0]*L[1][1]-L[1][0]*L[0][1];
      return ans; /*傳回 2 X 2 的答案*/
   } 
   else
      for (ai=0;ai<m;ai++)
      {
         /*用公式將矩陣化小*/
         /*去掉矩陣第一列*/
         for (i=0;i<m-1;i++)
            for (j=0;j<ai;j++)
               temp[i][j]=L[i+1][j];
         //這個迴圈跟下面那個的功能是互補的
	 //因為行列式的運算會畫一個十字架，把某些格子消掉
  	 //沒被劃掉的有時候會分成兩邊，所以要用兩個for loop分別存取
         //存完之後用遞迴的方式做運算
         /*去掉矩陣第 ai 行*/
         for (i=0;i<m-1;i++)
            for (j=0;j<(m-ai-1);j++)
               temp[i][ai+j]=L[i+1][ai+j+1];
         /* i+j 為偶數時,取正號 */
         if ((ai%2)==0)
            lans=L[0][ai]*determinant(m-1,temp);
         /* i+j 為奇數時,取負號 */
         else
            lans=-1*L[0][ai]*determinant(m-1,temp);
         ans=ans+lans;
      }
   return ans; /*傳回答案*/
}
