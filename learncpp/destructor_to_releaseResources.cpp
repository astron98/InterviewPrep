#include<bits/stdc++.h>
using namespace std;

class Human{
private:
	string *name;
	int *age;
public:
	Human(string iname,int iage){
		name = new string;
		age = new int;
		
		*name = iname;
		*age = iage;
	}
	
	void display(){
		//printf("Hello, I'm %s and I'm %d years old.",*name,*age);
		cout<<"Hello, I'm "<<*name<<" and I'm "<<*age<<" years old \n";
	}
	
	~Human(){
		delete name;
		delete age;
		printf("All the memory are released.");
	}
};

int main(){
	Human *aman = new Human("Aman",21);
	aman->display();
	
	delete aman;
	aman = nullptr;
	return 0;
}
