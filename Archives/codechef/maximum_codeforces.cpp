#include<bits/stdc++.h>
using namespace std;

typedef  long long ll;

int main()
{
	ll n;
	scanf("%lld",&n);
	ll b[n];
	
	int i=0;
	for(i=0;i<n;i++)
		scanf("%lld",&b[i]);
	
	ll a[n];
	ll maxVal = 0;
	for(i=0;i<n;i++)
	{
		if(i==0)
		{
			//maxVal = 
			a[i] = b[i] + 0;
			continue;
		}
		maxVal = max(ll(0),max(maxVal,a[i-1]));
		a[i] = b[i] + maxVal;	
	}
	
	for(i=0;i<n;i++)
		printf("%lld ",a[i]);	
	
	printf("\n");
	return 0;
}
