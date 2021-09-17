#include <bits/stdc++.h>

#define db1(x) cout<<#x<<"="<<x<<'\n'
#define db2(x,y) cout<<#x<<"="<<x<<","<<#y<<"="<<y<<'\n'
#define db3(x,y,z) cout<<#x<<"="<<x<<","<<#y<<"="<<y<<","<<#z<<"="<<z<<'\n'
#define rep(i,n) for(int i=0;i< (int)(n);++i)
#define repA(i,a,n) for(int i=a;i<= (int)(n);++i)
#define repD(i,a,n) for(int i=a;i>= (int)(n);--i)
#define PI pair<int,int>
typedef long long ll;

using namespace std;

int main()
{
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(0);

	int t, n, x;
	cin >> t;
	while (t--) {
		cin >> n >> x;
		vector<int> v(n);
		rep(i, n) cin >> v[i];

		std::map<int, vector<int>> mp;
		rep(i, n) {
			mp[ceil(v[i] / x)].push_back(i);
		}

		printf("Case #%d: ", t + 1);
		for (auto it = mp.begin(); it != mp.end(); it++)
			for (int val : it->second)
				printf("%d ", val + 1);

		printf("\n");
	}
	return 0;
}
