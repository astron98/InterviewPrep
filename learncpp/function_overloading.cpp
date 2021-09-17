#include<iostream>
#include<string>
/*
 *  Function overloading: multiple functions with the same name 
 * 	but with different parameters.
 * */

using namespace std;

void display();
void display(char* name);

int main()
{
	display();
	display("sapien");
	return 0;
}

void display()
{
	printf("hola,there. \n");
}


void display(char *name)
{
	printf("hola, %s.\n",name);
}
