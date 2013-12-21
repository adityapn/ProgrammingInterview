/*
    Find min and max using divid and conqor 
*/
#include<iostream>

using namespace std;

int abs(int value){
	if (value < 0)
	{
		return -value;
	}
	return value;
}

int * minAndmax(int *array,int start,int end,int min,int max){
	// If the array has only one element
	if(start == end){
		int results[2] = {min,max};
		return &results;
	}
	else if(abs(start - end) == 1){
		// If it has two elements
		int results[2] = {0,0};
		if(array[start] < array[end]){
			results[0] = array[start];
			results[1] = array[end];
		}else{
			results[1] = array[start];
			results[0] = array[end];
		}
		return &results;
	}else{
		// If there are more than 2 elements 
		int mid = (start+end)/2;
		int left[2] = minAndmax(array,start,mid,min,max);
		int right[2] = minAndmax(array,mid+1,end,min,max);
		int results[0] = {0,0};
		if(left[0] < right[0]){
			results[0] = left[0];
		}else{
			results[0] = right[0];
		} 

		if (left[1] < right[1])
		{
			results[1] = left[1];
		}else{
			results[1] = right[1];
		}

		return &results;
	}

}
int main(){
	int elements[5] = {1,54,23,76,12};
	int *array = &elements;
	int results[2] = minAndmax(array,0,5,1,1);
	cout<<results;
	return 0;
}