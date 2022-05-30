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

	int a, b, c;
	cin >> a >> b >> c;
	int abc, ab, ac, bc;
	cin >> ab >> ac >> bc;
	cin >> abc;

	int onlyC = 0, abNotC = 0;

	onlyC = c - ac - bc + abc;
	abNotC = ab - abc;

	printf("%d %d", onlyC, abNotC);
	return 0;
}
