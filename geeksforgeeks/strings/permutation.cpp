#include<bits/stdc++.h>
using namespace std;
void permute(char* str,int start,int n);

void permute(char* str,int start,int n){
	
	for(int i=start;i<n;i++){
		swap(str[start],str[i]);
		if(i==n-1 && start==n-1){
			cout<<str<<" ";
		}
		else
			permute(str,start+1,n);
		swap(str[start],str[i]);	
	}
}


int main(){
    int t;
    scanf("%d\n",&t);
    while(t-- >0){
	char str[5];
	scanf("%s",str);
	permute(str,0,strlen(str));	// '0' is the start value
    }
	return 0;
}

