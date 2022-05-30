#include<bits/stdc++.h>
using namespace std;

class B;
class A{
int x;
public:
	void setData(int i){
		x = i;
	}
	
	//friend void min(A,B);  //friend function
	
	friend class B;		//friend class
};

class B{
int y;

public:
	void setData(int i){
		y = i;
	}
	
	void display(A &a){
		printf("value of x: %d \n",a.x);
	}
	
	void min(A,B);
};

void B::min(A a,B b){
	if(a.x <= b.y){
		printf("%d \n",a.x);
	}
	else{
		printf("%d \n",b.y);
	}
}

int main(){
	A a;
	B b;
	a.setData(3);
	b.setData(78);
	
	b.min(a,b);    //calling the friend function.
	b.display(a);
	
	return 0;
}

