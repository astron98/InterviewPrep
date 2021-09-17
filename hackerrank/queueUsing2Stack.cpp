/*
 * question: queue using 2 stacks.
 * 			 hackerrank solution.
 * */

#include <bits/stdc++.h>
using namespace std;

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    int q=0;
    scanf("%d\n",&q);
    stack<int> f,r;
    while(q-- >0){
        string s;
        getline(cin,s);
        int x=0,data=INT_MIN;
        if(s.size()==1){
            x=(s=="2")? 2:3;
        }
        else{
            x=1;
            data=stoi(s.substr(2,s.size()-2));
            //printf("data:%d\n",data);
        }
        //printf("x:%d\n",x);
        if(x==1)
            r.push(data);
        else{
            if(f.empty()){
                while(!r.empty()){
                    f.push(r.top());
                    r.pop();
                }
            }
            if(!f.empty()){
                if(x==2) f.pop();
                if(x==3) printf("%d\n",f.top());
            }
        }
    }
    return 0;
}
