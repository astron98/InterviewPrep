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

	int n, k, j;
	// cin >> t;
	// while (t--) {
	cin >> n >> k >> j;
	vector<int> v(n);
	rep(i, n) cin >> v[i];

	sort(v.begin(), v.end());
	int sum = 0;
	if (j - 1 >= k) {
		sum += v[j - 1];
		k--;
	}

	rep(i, k) {
		sum += v[i];
	}
	printf("%d", sum);

	cout << '\n';
	// }
	return 0;
}
