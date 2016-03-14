#include<cstdio>
#include<algorithm>
using namespace std;
int a[1010],b[1010];                               //田忌和齊王的馬速序列
int main()
{
    int n;
    while(scanf("%d",&n),n)                       //輸入田忌和齊王馬的匹數
    {
        for(int i=1; i<=n; i++)  scanf("%d",&a[i]);   //輸入田忌n匹馬的速度
        for(int i=1; i<=n; i++)  scanf("%d",&b[i]);   //輸入齊王n匹馬的速度
        sort(a+1,a+1+n);                        //按照馬速遞增順序排列田忌的n匹馬
        sort(b+1,b+1+n);                       //按照馬速遞增順序排列齊王的n匹馬
        int tl=1,tr=n,ql=1,qr=n;           //A序列的首尾指標和B序列的首尾指標初始化
        int sum=0;                     //田忌贏得的銀幣數初始化
        while(tl<=tr)                   //若比賽未進行完
        {
            if(a[tl]<b[ql])              //若田忌最慢的馬慢于齊王最慢的馬，則田忌最慢的馬與齊王最快的馬比，輸一場
            {
                qr--;tl++;sum=sum-200;
            }
            else if(a[tl]==b[ql])          //若田忌最慢的馬與齊王最慢的馬速度相同
            {
                while(tl<=tr&&ql<=qr)   //迴圈，直至田忌或齊王的馬序列空為止
                {
                    if(a[tr]>b[qr])       //若田忌最快的馬快于齊王最快馬，則田忌最快的馬與齊王最快的馬比，贏一場

                    {
                        sum+=200;tr--;qr--;
                    }
                    else               //否則若田忌最慢的馬慢于齊王 最  快馬，則田忌最慢的馬與齊王最快的馬比，輸一場，退出while

                    {
                        if(a[tl]<b[qr])  sum-=200;
                        tl++;qr--; break;
                    }
                }
            }
            else                       //若田忌最慢的馬快于齊王最慢的馬，則田忌最慢的馬與齊王最慢的馬比，贏一場

            {
                tl++;ql++;sum=sum+200;
            }
        }
        printf("%d\n",sum);             //輸出田忌贏得的銀幣數
    }
    return 0;
}
