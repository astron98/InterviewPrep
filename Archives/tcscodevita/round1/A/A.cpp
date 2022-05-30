#include <bits/stdc++.h>

#define db1(x) cout<<#x<<"="<<x<<'\n'
#define db2(x,y) cout<<#x<<"="<<x<<","<<#y<<"="<<y<<'\n'
#define db3(x,y,z) cout<<#x<<"="<<x<<","<<#y<<"="<<y<<","<<#z<<"="<<z<<'\n'
#define rep(i,n) for(int i=0;i< (int)(n);++i)
#define repA(i,a,n) for(int i=a;i<= (int)(n);++i)
#define repD(i,a,n) for(int i=a;i>= (int)(n);--i)
#define PI pair<int,int>

using namespace std;
typedef long long ll;



int main()
{
/*
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
*/
	int t, n;
	scanf("%d", &t);
	while (t--) {
		scanf("%d", &n);
		vector<int> v(n);
		rep(i, n) scanf("%d", &v[i]);;

		int res = 1;
		int g[n];
		g[0] = 1;
		// int x = 0;
		repA(i, 1, n - 1) {
			// x=0;
			if (v[i] > v[i - 1])
				g[i] = g[i - 1] + 1;
			else if (v[i] < v[i - 1])
			{
				g[i] = g[i - 1] - 1;
				g[i] = (g[i] == 0) ? 1 : g[i];

			}
			else
				g[i] = g[i - 1];

			res += g[i];

		}
		//printf("\n");
		printf("%d\n", res);
		// cout << ;
	}
	return 0;
}
