#include <string>
#include <iostream>
#include <sstream> 
#include<bits/stdc++.h>
#define repA(i,a,n) for(int i=a;i<(int)n;i++)
#define repD(i,d,n) for(int i=d;i>=n;i--)
typedef long long ll;
using namespace std;

ll solver(int P, int Q, int h[], int g[], int n) {
    ll res = 0;
    int start = 0, end = n-1;
    
    if(n == 2)
        {
            if((h[0]>P && h[1]<2*P && h[0]<Q && h[1]<Q) || (h[0]<P && h[1]<P && h[0]<Q && h[1]<Q))
            {
                return (ll)max(g[0],g[1]);
            }
            else
            {
                return 0;
            }
        }
        else
        {
            int x = P/Q;
            if(x%2!=0 || x==0)
            {
                sort(g, g+n);
                ll temp=0;
                for (int i = 0; i <n ; i++) {
                    temp += (ll)g[i];
                }
                return temp - (ll)g[0];  
            }
            else
            {
                ll temp=0;
                for (int i = 0; i <n ; i++) {
                    temp += (ll)g[i];
                }
                return temp;
            }
        }
    
    return res;
}

int main()
{
//   string input;
    int p,q,n;
    int h[n],g[n];
    // read input
//   getline(cin, input);
    
    scanf("%d %d %d",&p,&q, &n);
    repA(i,0,n){
        scanf("%d %d", &h[i], &g[i]);
    }
  // print output
//   cout << input;

//sol
ll res = 0;
res = solver(p, q, h, g, n);
cout << res;


  return 0;
}


/*
testcases:

Asha should give up the first alien. During her first two turns she should soften up the third alien bringing it down to 80 hp, allowing her to easily get the last shot on the second and the third aliens

Here are some of there other test cases:

Input

50 60 2

40 100

40 90

Output - 100

Input

50 60 2

40 100

40 200

Output - 200

Input

50 100 2

60 100

60 200

Output - 200

Input

50 400 2

60 100

190 200

Output - 0
*/