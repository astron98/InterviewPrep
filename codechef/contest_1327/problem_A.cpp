#include<bits/stdc++.h>
using namespace std;

int main()
 {
	int t,n;
	
	scanf("%d",&t);
	while(t--)
	{
		scanf("%d",&n);
		vector<vector<int>> a(n);
		
		/*
		 * Caution: The 2D vector input itself is wrong....
		 * lesson: learn how to take the input efficiently.
		 * */
		for(int i=0;i<n;i++)
		{	
			//scanf("%d",a[i][0]);
			int x =0;
			scanf("%d",&x);
			vector<int> row;
			row.push_back(x);
			for(int j=1;j<=row[0];j++)
			{
				int x1=0;
				scanf("%d",&x1);
				row.push_back(x1);
			}
			a.push_back(row);
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<a[i].size();j++)
				printf("%d ",a[i][j]);
			printf("\n");	
		}
		printf("printed...\n\n");
		
		unordered_set<int> d,nd;
		unordered_set<int>::iterator itr;
		
		
		int flag=0;
		for(int i=0;i<n;i++)
		{
			
			if(d.find(a[i][1])==d.end())
			{
				d.insert(a[i][1]);
				for(auto it=a[i].begin()+2;it!=a[i].end();it++)
				{
					if(d.find(*it)==d.end())
						nd.insert(*it);
				}
				//nd.insert(a[i].begin()+2,a[i].end());
				if(nd.find(a[i][1])!=nd.end())
					nd.erase(a[i][1]);
			}
			else
			{
				
				if(nd.size()>0)
				{
					/*
					 * iterate throught the'nd'set and find the kingdom
					 * which is not present in the array of the current 
					 * queen and make that kingdom as an improvement
					 * 
					 * if not found 
					 * 			print = "OPTIMIZE"
					 * */
					for(itr=nd.begin();itr!=nd.end();itr++)
					{
						//find(row->begin(), row->end(), item) != row->end()
						if(a[i].size()>=2)
						{
							if(find(a[i].begin()+2,a[i].end(),*itr)==a[i].end())
							{
								flag=1;
								printf("IMPROVE\n");
								printf("%d %d \n",i+1,*itr);
								break;
							}
						} 
						else
						{
							flag=1;
							printf("IMPROVE\n");
							printf("%d %d \n",i+1,*itr);
							break;
						}
						
					}
					
					if(flag==0)
					{
						flag=1;
						printf("OPTIMIZE\n");
					}
					break;
				}
				else
				{
					nd.insert(a[i].begin()+2,a[i].end());
				}
			}
		}
		
		if(flag==0)
			printf("OPTIMIZE\n");
			
	}
	return 0;
}

