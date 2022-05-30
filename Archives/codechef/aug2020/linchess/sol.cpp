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

void solve(vector<int> &v, int n, int k) {
	int t = 0, res = INT_MAX, mn = -1;
	for (int x : v) {

		if (x <= k && (k - x) % x == 0) {
			t =  (k - x) / x;
			res = min(res, t);
			if (res == t)
				mn = x;

		}
	}
	cout << mn;
}

int main()
{
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	// cout.tie(0);

	int t, n, k;
	cin >> t;
	while (t--) {
		cin >> n >> k;
		vector<int> v(n);
		rep(i, n) cin >> v[i];

		solve(v, n, k);

		cout << '\n';
	}
	return 0;
}

