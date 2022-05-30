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

void solve(int h, int p) {
	int x, y;
	if (h < p) {
		cout << "1";
		return;
	}
	x = ceil(h / p);
	y = floor(p / (x * 2));

	if (x > y)
		cout << "0";
	else
		cout << "1";
}

int main()
{
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(0);

	int t, h, p;
	cin >> t;
	while (t--) {
		cin >> h >> p;
		// vector<int> v(n);
		// rep(i, n) cin >> v[i];

		solve(h, p);

		cout << '\n';
	}
	return 0;
}
