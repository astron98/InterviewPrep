#include<iostream>
#include<string>

using namespace std;


struct address{
	int houseNo;
	string streetName;
};

//this 'student' structure is globally available to the whole program.
struct student 
{	
	string name;
	int rollno;
	address addr;
	  
}Esmail,Baruto;

int main()
{
	student aman;
	aman.name = "Aman";
	aman.rollno = 123;
	
	aman.addr.houseNo = 62;
	aman.addr.streetName = "MG road";
	
	//printf("%s ",aman.name);
	cout<<aman.name<<" ,";
	printf("%d ,",aman.rollno);
	printf("%d ,",aman.addr.houseNo);
	cout<<aman.addr.streetName<<" \n";
	//printf("%s \n",aman.addr.streetName);
	
	return 0;
}

