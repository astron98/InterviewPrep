#include <bits/stdc++.h>
using namespace std;
#define l(i,n) for(int i=0;i<n;i++)
#define l1(i,n) for(int i=1;i<n;i++)
typedef long long ll;

void updateT(vector<int> adj[],int r,int t,ll a,ll b) {
    ll x = 
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */ 
    int n =0,x,y,q;
    scanf("%d",&n);
    vector<int> adj[n+1];
    l(i,n-1) {
        scanf("%d %d",&x,&y);
        adj[x].push_back(y);
        adj[y].push_back(x);      
    }
    scanf("%d",&q);
    string s="";
    l(i,q) {
        getline(cin,s);
    }
    
    return 0;
}

