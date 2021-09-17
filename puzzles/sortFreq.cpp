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

bool comp(const vector<int> &a, const vector<int> &b) {
    if(a[1]==b[1])
        return a[0] <= b[0];
    return a[1] > b[1];
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int t,n;
    cin>>t;
    while(t--){
        cin>>n;
        vector<int> v(n);
        rep(i,n) cin>>v[i];
        
        vector<vector<int> > a(61,vector<int>(2,0));
        // memset(a,0,sizeof(a));
        for(int i=0;i<(int)n;i++) {
            
            a[v[i]][1]++;
        }
        sort(a.begin(), a.end(), comp);
        
        for(int i=0;i<61;i++) {
            if(a[i][0]==a[i][1] && a[i][0]==0) break;
            cout << a[i][0]<<" ";
        }
        
        
        printf("\n");
    }
    return 0;
}
