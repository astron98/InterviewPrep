/*
 *  template functions in c++ :
 * 	Syntax: template <template-parameters> function-declaration
 * 
 * */
 
 #include<stdio.h>
 using namespace std;
 
 template <class T> 
 T sum(T a,T b)
 {
	T result = a+b;
	return result;
 }
 int main()
{
	int k,i=5,j=4;
	double l,x=8.7,y=5.6;
	k = sum<int>(i,j);
	l = sum<double>(x,y);
	
	printf("%d \n",k);
	printf("%lf \n",l);
	return 0;
}
