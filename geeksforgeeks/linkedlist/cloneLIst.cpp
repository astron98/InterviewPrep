#include<bits/stdc++.h>
using namespace std;
#define l(i,n) for(int i=0;i<(int)n;i++)

vector<int> printPascal(int n) {
	vector<int> curr(1,1);
	
	int x1,x2;
	if(n==0){
		return curr;
	}	
	else {
		
		vector<int> previous = printPascal(n-1);
		l(i,previous.size()-1) {
			x1 = previous[i];
			x2 = (i+1 < (int)previous.size())? previous[i+1]:0;
			curr.push_back(x1 + x2);
		}
		curr.push_back(1);
	}
	return curr;
	
}

int main() {
	int n = 6;
	vector<int> result = printPascal(n);
	printf("result:\n");
	for(int x:result) {
		printf("%d ",x);
	}
	printf("\n");
	
}


