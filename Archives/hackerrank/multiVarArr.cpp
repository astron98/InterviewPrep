#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    int n,q;
    cin >> n >>q;
    vector<int> a[n];
    for(int i=0;i<n;i++){
        int m;
        cin >> m;
        for(int j=0;j<m;j++){
            int m1;
            cin>>m1;
            a[i].push_back(m1);
        }
    } 
    // vector<int> b[q];
    // 
    int i1,i2;
    for(int k=1;k<=q;k++)
    {
        //printf("hola!\n");
        cin>>i1>>i2;
        cout<<a[i1][i2]<<"\n";
    }
    // printf("hola!\n");
    return 0;
}
