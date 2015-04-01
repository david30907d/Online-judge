#include<iostream>
using namespace std;

int main()
{
    int a,b;
    while(cin>>a)
    {
      b=0;
      bool positive=true;
      if(a<0)
      {
        positive=false;
        a*=-1;
      }
      while(a>0)
      {
        b*=10;
        b+=a%10;
        a/=10;
      }
      cout<<b<<endl;
    }
}
