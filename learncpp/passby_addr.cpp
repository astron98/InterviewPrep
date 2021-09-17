#include<iostream>
using namespace std;

void display(int *ptr);
int main()
{
	int age = 40;
	display(&age);
	
	printf("%d \n",age);
	return 0;
}

void display(int *ptr)
{
	printf("%d \n",*ptr);
	//int **p2 = &ptr;
	//**p2 = 78;
	*ptr = 99;
	
}
