#include <iostream>
using namespace std;

//int main() {
  //int *ptr;      //creating a pointer named ptr
  //int num = 4;    //intilizaing an int type variable named num with value 4
  //cout << "The integer input is: " << num <<endl;
  //ptr = new int[num];  //using new to initialize the ptr array with size num and dynamically allocated memory in heap
  //cout << "Input " << num << " integers\n";
  //for (int i = 0; i < num; i++){
    //ptr[i] = i+1;   //assigning value i+1 to the index i of ptr array
    //cin >> ptr[i];  // we cin this value 
  //}
  //cout << "Elements entered by you are\n";
  //for (int i = 0; i < num; i++){
    //cout << ptr[i] << endl;    //displaying the values that we passed through cin above
  //}
  //delete[] ptr;      // now that we are done using ptr, we delete the array 
                   //// and free the part of memory which was allocated to it in the heap
  //printf("the memory has been freed.\n");
  //return 0;
//}


//#include <stdio.h>
//#include<iostream>

int main()
{
    
    printf("Hello World\n");
    string x="0";
    x+=to_string(78);
    //printf("string: %s",x);
    cout<<"string: "<< x <<endl;
    return 0;
}
