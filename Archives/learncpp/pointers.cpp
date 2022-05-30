
#include<iostream>
#include<cmath>

using namespace std;

int main()
{
	int age = 19,age1=34;
	int *p1 = &age;
	int *p2 = &age1;
	int **p3=&p1;
	p1 = p2;
	//double gpa = 2.4;
	//double *pGpa = &gpa;
	
	cout << *p1 << endl;
	cout << &p1 << endl;
	cout << p3 << endl;
	cout << &p3 << endl;
	cout << *p3 << endl;
	cout << &age1 << endl;
	cout << &age << endl;
	
	int a,b;
	cin>>a>>b;
	cout<<a << ","<<b<<"\n";
	
	return 0;
}
