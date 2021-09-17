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

void solve(int a, int b) {
	printf("inputs: %d,%d\n", a, b );
	int c1 = 0, c2 = 0;

	while (a > 9) {
		c1 += a / 9;
		a %= 9;
	}

	while (b > 9) {
		c2 += b / 9;
		b %= 9;
	}

	if (a > 0) c1++;
	if (b > 0) c2 ++;
	if (c1 < c2) {
		cout << "0 " << c1;
	}
	else
		cout << "1 " << c2;
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

	int t, a, b;
	cin >> t;
	while (t--) {
		cin >> a >> b;
		// vector<int> v(n);
		// rep(i, n) cin >> v[i];
		solve(a, b);
		cout << '\n';
	}
	return 0;
}
