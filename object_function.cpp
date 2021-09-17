#include<iostream>
#include<cmath>

using namespace std;

class movie
{
	private:
		int rating;
	public:
		string title,director;
		
		
		//constructor in cpp.
		movie(string atitle,string adirector,int arating)
		{
			//cout << "creating object." << endl;
			title = atitle;
			director = adirector;
			setRating(arating);
		}
		
		void setRating(int aRating)
		{
			rating = aRating;
		}
		
		int getRating()
		{
			return rating;
		}
};

int main()
{
	//creating an object of class "Book"
	movie m1("Gone Girl","Ben Affleck",8);
	
	
	cout << m1.getRating();
	
	return 0;
}

