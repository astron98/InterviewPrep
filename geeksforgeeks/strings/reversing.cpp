#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main()
 {
	//code
	int t;
	scanf("%d\n",&t);
    while((t--) > 0){
        string s;
        getline(cin,s);
        
        stringstream ss(s);
        string temp;
        vector<string> result;
        
        while(getline(ss,temp,'.')){
            result.push_back(temp);
        }
        int i=result.size()-1;
        temp.erase();
        while(i>0){
            temp.append(result[i--]+".");
        }
        temp.append(result[0]);
        //temp.resize(temp.size()-2);
        cout<< temp<<"\n";
    }
	
	return 0;
}
