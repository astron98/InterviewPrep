// Created by astron98
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

	int t, n;
	cin >> t;
	while (t--) {
		cin >> n;
		vector<vector<char>> v = {
			{'r', 'r', 'r', 'g'},
			{'r', 'r', 'g', 'g'},
			{'r', 'r', 'g', 'g'},
			{'r', 'g', 'g', 'g'},
		};
		// rep(i, n) cin >> v[i];

		for (int j = 1; j < (int)v.size(); j++) {
			for (int i = 1; i < n; i++) {

			}
		}


		cout << '\n';
	}
	return 0;
}

/*
Testcases:

case 1:
input:
RRRG
RRGG
RRGG
RGGG
output:

-------------------------------
*/
