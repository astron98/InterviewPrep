#include<bits/stdc++.h>
using namespace std;

class Address{
public:
	string addressLine,city,state;
	
	Address(string addressLine,string city,string state){
		this->addressLine = addressLine;
		this->city = city;
		this->state = state;
	}
};

class Employee{
private:
	Address address;  //Employee HAS-A Address
public:
	int id;
	string name;
	Employee(int id,string name,Address address){
		this->id = id;
		this->name = name;
		this->address = address;
	}
	
	void display(){
		cout<< id<<" "<<name<<" \n";
		cout << address.addressLine<<" "<<address.city<<endl;
	}
};

int main(){

	Address a1("C-146,Sec-15","Noida","UP");
	Employee e1(101,"Aman",a1);
	e1.display();
	return 0;
}
