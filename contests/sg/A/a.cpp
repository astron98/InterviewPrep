#include <bits/stdc++.h>

using namespace std;
/*
1. convert num to string inorder
2. sum of all the digits.
3. remove zeros.
4. print the odd/even string according to the sum value.
*/

string solve(int n) {
	stringstream ss;
	ss << n;
	string alp = "", res = "";
	ss >> res;
	cout << res << " temp res\n";
	res.erase(remove(res.begin(), res.end(), '0'), res.end());
	int sum = 0;
	for (char c : res) {
		//cout << int(c) << ", ";
		c = c - '1' + 'A';
		sum += c - '0';
		alp += c;
	}
	sort(alp.begin(), alp.end());
	res = "";
	for (char c : alp) {
		int temp = c - '0';
		if (sum & 1) {
			if (temp & 1)
				res += c;
		}
		else {
			if (temp % 2 == 0)
				res += c;
		}
	}
	cout << "\n" << alp << " alp value, " << res << "\n";
	printf("%d\n", sum);

	return res;
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

	int t, n;
	cin >> t;
	while (t--) {
		cin >> n;
		string res = solve(n);
		cout << res << "\n";
	}

	return 0;
}
