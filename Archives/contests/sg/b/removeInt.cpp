/*
	1. remove all the integeres from the string.
	2. print the sum of the integers.
*/

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



string solve(string s) {
	//cout << s << "\n ";
	int sum = 0;
	string temp = "";
	for (char c : s) {
		if (c >= '0' && c <= '9') {
			//cout << c << ", ";
			temp += c;
		}
		else if (temp != "") {
			sum += stoi(temp);
			temp = "";
		}
	}
	printf("%d =sum\n", sum);
	string nm = "0123456789";
	for (char c : nm)
		s.erase(remove(s.begin(), s.end(), c), s.end());
	//cout << "\ns modified: " << s << "\n";
	return s;

}

int main()
{
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int t, n;

	string str = "";
	// while (t--) {
	getline(cin, str);
	cout << str << " = input string\n ";

	string res = "";
	res = solve(str);
	cout << res << "\n";
	//print the sum of the integers.

	// }
	return 0;
}
