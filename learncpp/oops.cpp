#include<bits/stdc++.h>
using namespace std;

/*
 * 1,2. OOPS in C++.
 * 3. Scope resolution operator (::)
 * 4. private - access specifier.		
 * 
 * */

class HumanBeing
{
	/*
	 * Note: 
	 * 1. members of the class are 'PRIVATE' by default.
	 * 2. PRIVATE members can only be accessed only from inside the class.
	 */
	private: 
		int age;
		string nameP;
		
		int getAge(){
			return age-5;
		}
	public:
		HumanBeing()
		{
			nameP = "noname";
			age = 0;
			printf("Constructor of 'HumanBeing'is called.\n");
		}
		
		HumanBeing(string name1,int age1)
		{
			nameP = name1;
			age = age1;
			printf("Parameterized-Constructor of 'HumanBeing'is called.\n");
		}
		
		//default values in the constructor-parameter.
		
		
		void displayP()
		{
			cout<<nameP<<" "<< age<<endl;
		}
		
		string name;
		
		void introduce()
		{
			cout<<"hi I'm "<<name<<".\n";
		}
		
		void display();
		
		void displayAge(){
			cout << getAge() << endl;
		}
		
		void setAge(int age){
			this->age = age;
		}
};

void HumanBeing::display(){
	cout << HumanBeing::name <<endl;
}

int main()
{
	HumanBeing sapien,o1;
	
	/*
	 * We use a dot(.) operator to access the members of the class,
	 * with the prefix as the 'object' of the class.
	 * */
	sapien.name = "whoami";
	sapien.introduce(); 
	
	o1.name = "Rohan";
	o1.introduce();
	 
	 
	/*
	 * Part 2: Creating the Objects in different ways.
	 * */
	 
	 
	// here the object memory will be allocated in the stack.
	HumanBeing o2;
	 
	 // here the object memory will be allocated in the heap(better option).
	 // the 'new' keyword returns the pointer pointing to the,
	 // newly allocated memory-location.
	HumanBeing *o3 = new HumanBeing();
	
	/*
	 * NOTE: Since, here the object is a pointer,
	 *       So,we use '->' arrow operator to access 
	 *       the members of the class.
	 * */
	 
	o3->name = "bunty";
	o3->introduce();
	/* or */
	(*o3).introduce();

	/*-----------------------------------------------------------
	* Part3: the Scope resolution operator.
	*/
	HumanBeing *scope = new HumanBeing;
	cout<<"---------------------scope---------------------\n";
	scope->name = "Amit";
	scope->display();

	/*-----------------------------------------------------------
	* Part4: PRIVATE access specifier.
	*/
	cout<<"---------------------private---------------------\n";
	//scope->age = 24;  //error
	
	scope->displayP();
	scope->setAge(24);
	scope->displayAge();
	
	/*-----------------------------------------------------------
	* Part5: Parameterized-Constructor.
	*/
	cout<<"---------------Parameterized-Constructor-----------------\n";
	HumanBeing pc("Elliot",21);
	pc.displayP();
	
	return 0;
}
