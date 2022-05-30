#include <iostream>
#include <string.h>  // "for using c-style strings in c++ programs"


//using namespace std;
#define LOG(x) std::cout<< x << "\n";

void changeStr(std::string& str) {
	str += "fg";
}

int main()
{	
	/*
	int x = 1;
	string s = to_string(x + 48);
	cout<<"string val: "<< s <<"\n";
	
	//c-style strings
	const char* name = "Charlie";
	char name1[8] = {'C','h','a','r','l','i','e','\0'};	
	// with a null termination character in the end '\0' 'charlie\0'
	//name[6] = 't';
	
	cout << "size of name1: " << sizeof(name1)/sizeof(char) <<"\n";	//size = 8
	LOG(name1);
	
	//string is basically a " char* "
	string name2 = "Puth";
	
	//name2 = "asdfa";
	changeStr(name2);
	LOG(name2);
	*/
	
	//2. String literals is basically string in quotes. eg:"charlie"
	char* nm = "cher\0no"; // u should always make a char* const in c++
	//nm[1] = 'b';	//char* is immutable in c/c++
	std::cout << strlen(nm) << "\n";
	
	return 0;
}
