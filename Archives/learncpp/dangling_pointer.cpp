#include<iostream>
using namespace std;
/*
 * 1. Dangling pointer
 * 2. 'auto' keyword - "Automatic type deduction"
 * */

int main()
{
	int *ptr=nullptr;
	
	ptr = new int;
	if(ptr!=nullptr)
	{
		*ptr=10;
		cout<<*ptr<<"\n";
		delete ptr;
		ptr = nullptr;
		cout<<ptr<<endl;
	}
	else
	{
		cout<<"memory not allocated.\n";
	}
	
	// 2. auto - keyword.
	auto something = "whiamasdf";
	auto x;
	cout<<something<<endl;
	cout<<x<<endl;
	
	return 0;
}
