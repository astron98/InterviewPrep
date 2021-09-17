#include<bits/stdc++.h>
using namespace std;

class Person{
public:
	string name;
	int age;
	void setName(string iname){ name = iname; }
	void setAge(int iage){ age = iage; }
	
};

//Student-class(subclass) inherited from the above base-class-(Person)
class Student : public Person{
public:
	int id;
	void setId(int iId){id = iId; }
	
	void introduce(){
		cout<<"Hi,I'm "<<name<<" and I'm "<<age<<" years old, my studentId is "<<id<<endl;
	}
};

int main(){
	Student aman;
	aman.setName("aman");
	aman.setAge(23);
	aman.setId(3425);
	
	aman.introduce();
	
	return 0;
}
