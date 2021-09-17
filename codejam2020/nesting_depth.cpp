#include<bits/stdc++.h>
using namespace std;


int main(){
	
	//two steps for fast-I/O in c++.
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

    int t=1,z=1;
    scanf("%d",&t);
    while(z <=t){
		string s,ans="";
		
		getline(cin,s);
		//cout<< "input string:"<<str<<"\n";
		int n =s.size(); //size of the input string.
		int pos=0; //current position in the ans string.
		string c="";
		int flag=0;
		for(int i=0;i<n;i++)
		{	
			if(flag==1){
				flag=0;
				c.clear();
			 
			}
			c += s[i];
			if(i<n && s[i]==s[i+1]) 
				continue;
			else
				flag=1;
				
		if(c[0]=='0'){
			ans.insert(pos,c);
			pos+=c.size();
			//if(pos>ans.size()) pos--;
			//else
			//{
				
			//}
			continue;
		}
		string ss(c,0,1);
		int pp=stoi(ss);
		string l(pp,'(');
		string r(pp,')');
		if(c[0]!='0' && ans.size()>0)
		{
			l.clear();r.clear();
			int f=pos,fc=0;
			
			while(f<ans.size() && ans[f]!='(')
			{
				if(ans[f]==')') fc++;
				f++;
			}
			if(fc<c.size() ){	//&& ans[pos-1]!='0'
				l.insert(0,pp-fc,'(');
				r.insert(0,pp-fc,')');
			}
			//else if(ans[pos-1]=='0' &&  fc==0){	
					//l.insert(0,c.size()-fc,'(');
					//r.insert(0,c.size()-fc,')');
					
			//}
			l+=c+r;
			ans.insert(pos,l);
			pos+=(l.size()-r.size())+1;
		}
		else{
			l+= c+r;
			
			ans.insert(pos,l);
			pos+=(l.size()-r.size())+1;
			//ans+=r;	
		}
		}
		
		cout<<"Case #"<<z-1<<": "<<ans<<"\n";
		
		z++;
    }
	
	return 0;
}
