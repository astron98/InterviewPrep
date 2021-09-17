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
// #ifndef ONLINE_JUDGE
// 	freopen("input.txt", "r", stdin);
// 	freopen("output.txt", "w", stdout);
// #endif

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(0);

	int n, m;
	cin >> n;
	map<string, vector<int>> a;
	string s;
	int b, c;
	rep(i, n) {
		cin >> s >> b >> c;
		a[s] = vector<int>(4, 0);
		a[s][0] = b;
		a[s][1] = c;
	}
	cin >> m;
	// vector<int> b(m);
	b = 0, c = 0;
	rep(i, m) {
		cin >> s >> b >> c;
		a[s][2] = b;
		a[s][3] = c;
	}
	ll res = 0;


	for (auto i : a) {
		vector<int>& v = i.second;

		res += (v[3] * v[2]);
		v[0] -= v[2];
	}

	for (auto i : a) {
		vector<int>& v = i.second;

		res += (v[0] * v[1]);
	}
	cout << res ;

	return 0;
}
