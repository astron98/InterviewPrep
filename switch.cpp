#include<iostream>
using namespace std;

//day of the week program
string getDayOfWeek(int dayNum)
{
	string dayName;
	switch(dayNum)
	{
		case 1:
			dayName="Sunday";
			break;
		case 2:
			dayName="Monday";
			break;
		case 3:
			dayName="Tueday";
			break;
		case 4:
			dayName="Wednesday";
			break;
		case 5:
			dayName="thursday";
			break;
		case 6:
			dayName="friday";
			break;	
		case 7:
			dayName="Saturday";
			break;
		default:
			dayName = "Invalid day Number";
			break;		
	}
	
	return dayName;
}

int main()
{
	int dayNum;
	cout << "Enter day number of the week: ";
	cin >> dayNum;
	cout << getDayOfWeek(dayNum);
	return 0;
}
