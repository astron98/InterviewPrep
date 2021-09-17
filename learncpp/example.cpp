#include<bits/stdc++.h>
using namespace std;

class Simple {
public:
	int a;
	Simple(){
		a = 1;
	}
};

int main(){
	Simple obj;
	Simple *ptr = &obj;	//pointer of class-type
	
	printf("%d \n",obj.a);
	cout<< ptr->a;	//Accessing member with pointer.
	
	return 0;
}
