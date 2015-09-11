#include<cstdio>
//#include<cstring>
//#include<cctype>
#include<algorithm>
using namespace std;
const int maxn=1000001;
long long A[maxn],c[maxn],tot,m;
int main(){
	int n=0;
	while(scanf("%d",&n)!=EOF){
		tot=0;
		for(int i=0;i<n;i++){
			scanf("%lld",&A[i]);
			tot+=A[i];
		}
		m=tot/n;
		c[0]=0;
		for(int i=1;i<n;i++){
			c[i]=c[i-1]+A[i]-m;//C是要移動到平均硬幣樹的距離 
		}
		sort(c,c+n);
		long long x1=c[n/2],ans=0;
		for(int i=0;i<n;i++){
			ans+=abs(x1-c[i]);
		}
		printf("%d",ans);
	}
	return 0; 
}

