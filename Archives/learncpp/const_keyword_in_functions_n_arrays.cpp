
#include<iostream>
using namespace std;

//we can't change the value assigned to a 'const' variable

void display(const int *num,int limit);

int main()
{
	const int pi = 3.142;  //a const variable
	
	int num[] = {22,11,44,55,66};
	display(num,5);
	return 0;
}


void display(const int *num,int limit)
{
	for(int i=0;i<limit;i++)
	{
		//num[i] = 0;  //it gives you an error.
		printf("%d \n",num[i]);
	}
}


