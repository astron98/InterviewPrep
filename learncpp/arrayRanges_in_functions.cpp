#include<iostream>
using namespace std;


void display(const int *start,const int *end);

int main()
{
	int num[] = {1,2,3,4,5,6,7,8,9};
	
	printf("array_size: %d \n",sizeof(num)/sizeof(num[0]));
	
	display(num,num+sizeof(num)/sizeof(num[0]));
	
	return 0;
}

void display(const int *start,const int *end)
{
	const int *ptr;
	for(ptr = start;ptr!=end;ptr++)
		printf("%d, ",*ptr);
}
