#include<bits/stdc++.h>
using namespace std;

class Human{
public:
	static int human_count;
	
	Human(){
		human_count++;
	}
	
	void humanTotal(){
		printf("There are %d people in this program.\n",human_count);
	}
	
	
	/*
	 * 
	 * Scope of the static methods:
	 * The static method is shared to all the instances(a.k.a- objects),
	 * of the class.
	 * 
	 * note: we can only use static variables in the static methods.	
	 * */
	static void humanCount(){
		printf("There are %d people in this program.\n",human_count);
	}
};

int Human:: human_count = 0;

int main(){
	printf("human_count_before: %d \n",Human::human_count);
	
	Human aman;
	Human rachit;
	
	Human::humanCount();
	
	printf("human_count_After: %d \n",Human::human_count);
	
	return 0;
}
