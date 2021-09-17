#include<bits/stdc++.h>
using namespace std;

#define l(i,n) for(int i=0;i<n;i++)
#define l1(x,i,n) for(int i=x;i<=n;i++)
typedef long long ll;

void calc(int x,int y,int &c) {
	while(x>0 && y>0) {
		if(x==1 || y==1) {
			c+= (x*y);
			x=0;y=0;
			return;
		}
		else {
			c = c+1;
			if(x<y)
				y -= x;
			else if(x>y)
				x -= y;
			else {
				x=0;y=0;
			}
		}	
	}	
}

int main()
 {
	int p,q,r,s;
	scanf("%d",&p);
	scanf("%d",&q);
	scanf("%d",&r);
	scanf("%d",&s);
	int c=0;
	l1(p,i,q) {
		l1(r,j,s) {
			calc(i,j,c);
		}
	}
	printf("count: %d\n",c);
	return 0;
}
