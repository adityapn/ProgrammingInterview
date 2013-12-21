/*
   Two sorted arrays A and B are given ,
   We need to merge them to form a new sorted array 
   which has both array elements
*/


#include<stdio.h>

void merge(int [],int [],int ,int );

int main(){

   int array1[] = {1,3,5};
   int array2[] = {2,4,6};
   int len1 = sizeof(array1)/sizeof(int);
   int len2 = sizeof(array2)/sizeof(int);

   merge(array1,array2,len1,len2);

   return 0;
}

void merge(int array1[],int array2[],int len1,int len2){
     int i = 0;
     int j = 0;
     int count = 0;
     int size = len1+len2;
     int endArray[size];
     while(i < len1 && j<len2){
          if(array1[i] < array2[j]){
               endArray[count] = array1[i];
               i++;
               count++;
               if(i == len1){
                    endArray[count] = array2[len2-1];
                    count++;
                    j++;
               }

          }else{
               endArray[count] = array2[j];
               j++;
               count++;
          }
     }
     int temp = 0;
     for(;temp<size;temp++){
        printf("%d ",endArray[temp]);
     }
}