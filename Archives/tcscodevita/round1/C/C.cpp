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

bool compareT(PI a, PI b) {
	return a.first < b.first;
}

int main()
{
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int t = 1, n;
	// cin >> t;
	// while (t--) {
	cin >> n;
	vector<PI> v;
	string input;
	int x, y;
	rep(i, n) {
		input = "";
		getline(cin, input);
		istringstream is(input);
		is >> x;
		is >> y;
		// printf("%d %d\n", x, y);
		v.push_back(make_pair(x, x + y));
	}
	sort(v.begin(), v.end(), compareT);
	int res = 1;
	for (int i = 1; i < n; i++) {
		// printf("%d %d\n", v[i].first, v[i].second);
		if (v[i].first <= v[i - 1].second)
		{
			res++;
		}
		// else
		// 	res--;
	}
	printf("%d", res);

	return 0;
}

/*
test cases:

1.
(5,15),(10,12) (20,25)
*/