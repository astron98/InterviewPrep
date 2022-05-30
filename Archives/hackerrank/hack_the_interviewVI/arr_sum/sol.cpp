#include <bits/stdc++.h>

#define db1(x) cout<<#x<<"="<<x<<'\n'
#define db2(x,y) cout<<#x<<"="<<x<<","<<#y<<"="<<y<<'\n'
#define db3(x,y,z) cout<<#x<<"="<<x<<","<<#y<<"="<<y<<","<<#z<<"="<<z<<'\n'
#define rep(i,n) for(int i=0;i< (int)(n);++i)
#define repA(i,a,n) for(int i=a;i<= (int)(n);++i)
#define repD(i,a,n) for(int i=a;i>= (int)(n);--i)
#define PI pair<int,int>

using namespace std;
using ll = long long;

void solve(int N, std::vector<int> &op) {
	vector<long> res;
	// vector<long>::iterator it;
	// unordered_set<long> s;
	// for(long i=1;i<=N;i++) {
	//     s.insert(i);
	// }

	int temp = 0, first = 1, last = N;
	long t = (long)N * ((long)N + 1) / 2;
	for (int x : op) {
		if (x == first || x == last || (x >= 2 && x <= N - 1)) {
			swap(first, last);
			// cout << res[N-1]<<" \n";
		}
		else {
			t += ((long)x - last);
			last = x;
			// temp = res[0];
			// res[0] = res[N-1];
			// res[N-1] = temp;
			// cout << res[0]<<" \n";
			// cout << res[N-1]<<" \n";
		}
		res.push_back(t);
	}

	rep(i, res.size()) {
		cout << res[i] << " ";
	}
	cout << "\n";
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

	int t, n, m;
	cin >> t;
	while (t--) {
		cin >> n;
		cin >> m;
		vector<int> op(m);
		rep(i, m) cin >> op[i];

		solve(n, op);

		cout << '\n';
	}
	return 0;
}
