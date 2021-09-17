#include<bits/stdc++.h>
using namespace std;

int main(){
    int t=1,z=1,n=0;
    scanf("%d",&t);
    
    while((z++) <=t){
    scanf("%d",&n);
    vector<vector<int>> arr(n);
    int i=0,j=0;
    for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			int in = 0;
			scanf("%d",&in);
			arr[i].push_back(in);
		}
    }
    
    int k1=0,r=0,c=0;
    //int rc[n<<1]={0};
    int r1[n]={0};
    int c1[n] = {0};
    for(i=0;i<n;i++){
		
		k1+=arr[i][i];
		for(j=0;j<n;j++){
			int x = arr[i][j];
			if(find(arr[i].begin()+j+1,arr[i].end(),x)!=arr[i].end())
			{	
				if(r1[i]!=1)
				{ r1[i]=1; r++;}
			}
			for(int k=i+1;k<n;k++){
				if(arr[k][j]==x)
				{	
					if(c1[j]!=1)
					{ c1[j]=1; c++;}
					break;
				}
			}
		}
    }
    
		printf("Case #%d: %d %d %d\n",z-1,k1,r,c);
    }
    return 0;
}



