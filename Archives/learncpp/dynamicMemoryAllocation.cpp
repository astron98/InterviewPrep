#include<iostream>
using namespace std;


int main()
{
	/*
	 *  SYNTAX: new <datatype>
	 * 
	 * NOTE:The 'new' keyword returns the address of the allocated memory.
	*/
	
	int *ptr;
	
	//by default the pointer will be assigned a default value 0.
	ptr = new int;
	
	cout<<ptr<<endl;
	*ptr = 45;
	cout<<*ptr<<endl;
	delete ptr;
	
	/*
	 * Dynamically allocating the 'arrays'
	 * 
	 */
	int *ptr1 = nullptr;
	
	cout<< "enter the array size"<<endl;
	
	int size;
	cin>>size;
	
	ptr1 = new int[size];
	
	int temp;
	for(int i=0;i<size;i++)
	{
		cin>> temp;
		*(ptr1+i) = temp;
		
	}
	
	
	cout<< "The array elements are:\n";
	for(int i=0;i<size;i++)
	{
		
		cout<<*(ptr1+i)<<"\n";
		
	}
	
	delete[] ptr1;
	
	return 0;
}
