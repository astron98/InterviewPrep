#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int main()
 {
    //code
	int t=0;
	scanf("%d\n",&t);
	vector<pair<string,int>> special {
					{"IV",4},{"IX",9},{"XV",40},{"XC",90},{"CD",400},{"CM",900}
				 };
				 
	vector<pair<string,int>> common {
					{"I",1},{"V",5},{"X",10},{"L",50},{"C",100},{"D",500},{"M",1000}
				 };
				 			 
	while(t-- >0){
		unordered_map<string,int> mv,mv1;
		copy(special.begin(),special.end(),
			inserter(mv,mv.begin()));
		
		copy(common.begin(),common.end(),
			inserter(mv1,mv1.begin()));
			
		string a;
		getline(cin,a);
		int result=0,i=0;
		int n=a.size();
		while(i<n){
			
			string s;
			if(i<n-1)
				s=a.substr(i,2);
			//unordered_map<string,int>::iterator it;
			auto it = mv.find(s);
			//printf("IT->SECOND: %s\n",s);
			//cout<<"s value:"<<s<<" \n";
			//cout<<"a value:"<<a<<"\n";
			
			if(it!=mv.end()){
				result+=it->second;
				++i;		
			}
			else{
				s.erase();
				s = a.substr(i,1);
				it = mv1.find(s);
				//cout<<"s1 value:"<<s<<",it->second:"<<it->second;
				if(it!=mv1.end()){
					int j=i,flag=1;
					
					while(j<n-1 && a[j]==a[j+1]){
						flag++;
						j++;
											
					}
					i=j;
					result+=(flag*(it->second));
				}
				
			}
			//printf("value of i:%d\n",i);
			i++;
		}
		
		printf("result: %d\n",result);	
			
				
			
	}
	return 0;
}
