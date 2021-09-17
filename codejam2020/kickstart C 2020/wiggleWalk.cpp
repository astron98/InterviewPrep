#include<bits/stdc++.h>
using namespace std;

int main()
 {	
 	//two steps for fast-I/O in c++.
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	int t,z=1,n=0,r=0,c=0,sr=0,sc=0;
	scanf("%d",&t);
	while(z<=t)
	{
	    scanf("%d %d %d %d %d",&n,&r,&c,&sr,&sc);
	    //cin>>n>>r>>c>>sr>>sc;
	    string s;
	    getline(cin,s);
	    vector<vector<int>> a(r,vector<int> (c,0));
	    int x=sr-1,y=sc-1,p=0,q=0;
	    for(int i=0;i<n;i++){
		p=0,q=0;
		if(s[i]=='E')
		    q=1;
		else if(s[i]=='S')
		    p=1;  
		else if(s[i]=='W')
		    q=-1;
		else if(s[i]=='N')
		    p=-1;
		
		a[x][y]=1;
		while(a[x][y]!=0){
		    x+=p;
		    y+=q;
		}
	    }
	    
	    printf("Case #%d: %d %d\n",z,x+1,y+1);
	    z++;
	}
	return 0;
}
