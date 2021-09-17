#include<iostream>

using namespace std;



//this 'student' structure is globally available to the whole program.
struct student 
{	
	int rollno;		//rollno
	char sex;		//gender
	int age;
	  
}Esmail,Baruto;

void display(student s);
void show(student *s);

int main()
{
	student Reema;
	Reema.rollno = 2;
	Reema.sex = 'F';
	
	Esmail. rollno = 1;
	Esmail.sex = 'M';
	
	// structure member as a pointer.
	student *esmailptr;
	esmailptr = &Esmail;
	
	
	// A pointer to a structure can be accessed using '->' arrow operator.
	esmailptr->rollno = 12;
	esmailptr->sex = 'm';
	
	//printf("%d \t %c \n",Esmail.rollno,Esmail.sex);
	printf("%d \t %c \n",Reema.rollno,Reema.sex);
	
	display(Esmail);
	show(esmailptr);
	
	cout<<endl;
	display(Esmail); 
	return 0;
}

void display(student s)
{
	printf("Using structures:\n%d \t",s.rollno);
	printf("%c \t",s.sex);
	printf("%d \n",s.age);
	
	s.rollno = 24;	//no change reflected in the show() function.
	
}

void show(student *s)
{
	printf("Using pointer to a structure:\n%d \t",s->rollno);
	printf("%c \t",s->sex);
	printf("%d \n",s->age);
	
	s->rollno = 23; 
}
