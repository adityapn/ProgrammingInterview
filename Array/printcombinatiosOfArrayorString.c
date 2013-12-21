/*
     If the string is "abc" then it's combinations are 
     a , b , c , ab , ac , abc . If can generate 2^N various combinations 
*/
#include<stdio.h>

void combinations(int binary[],int k,int n,char items[]);
void printcombinations(int binary[],int k,int n,char items[]);

int main(){
     int binary[4] = {0,0,0,0};
     char items[4] = {'a','b','c','d'};
     combinations(binary,0,3,items);
     return 0;
}

void combinations(int binary[],int k,int n,char items[]){
     if(k == n){
         binary[k] = 0;
         printcombinations(binary,k,n,items);
         binary[k] = 1;
         printcombinations(binary,k,n,items);
         return;
     }
     binary[k] = 0;
     combinations(binary,k+1,n,items);
     binary[k] = 1;
     combinations(binary,k+1,n,items);
}

void printcombinations(int binary[],int k,int n,char items[]){
     int sum = 0;
     int i=0;
     for(;i<=n;i++){
        if(binary[i] == 1){
          printf("%c",items[i]);
          sum++;
        }
     }
     printf("\n");
}