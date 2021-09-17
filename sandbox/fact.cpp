#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int fact(int n) {
	if (n <= 1)
		return 1;
	else
		return n * fact(n - 1);
}

int main() {
	int n;
	//printf("enter the number:");
	//scanf("%d",&n);
	// cout<< "output:"<<fact(n)<<"\n";

	int x = -1;

	if (x)
		printf("t\n");
	else
		printf("f\n");
	return 0;
}
