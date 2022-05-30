#include<iostream>
//sizeof() operator and unions in c++.

/*
 *  In unions the memory is shared between all the members.
 * */

union employee{
	int id;
	float salary;
}Ramesh,Rakshit;

using namespace std;

int main()
{
	//printf("%d",sizeof(int));
	cout << "int-->"<<sizeof(int)<<endl;
	cout << "char-->"<<sizeof(char)<<endl;
	cout << "long long-->"<<sizeof(long long)<<endl;
	
	employee anna;
	
	anna.id = 24;
	anna.salary = 35000;
	cout<<"\nunions starts here: \n";
	cout << anna.id<<" "<<anna.salary<<"\n";
	return 0;
}
