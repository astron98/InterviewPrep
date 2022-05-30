#include <bits/stdc++.h>
using namespace std;

class Human{
private:
	string name;
	int age;
public:
	Human(string name="noname",int age=0){
		printf("default constructor \n");
		this->name = name;
		this->age =age;
	}
	
	void speakUp(){
		cout<<name<<"  "<<age<<endl;
	}
	
	/*Note: We can't pass any parameter to the destructor.
	 *
	 * Destructor to deallocate the memory allocated to the object of a
	 * given class.
	 */
	~Human(){
		cout<< "destructor called. \n";
	}
};

int main()
{
	Human *amit = new Human();
	amit->speakUp();
	
	delete amit;
	return 0;
}
