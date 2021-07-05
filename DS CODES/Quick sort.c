#include <stdio.h>
#include <stdlib.h>

#define MAX 7
void printline(int count) {
   int i;
	
   for(i = 0;i < count-1;i++) {
      printf("=");
   }
	
   printf("=\n");
}

void display(int arr[]) {
   int i;
   printf("[");
   for(i = 0;i < MAX;i++) {
      printf("%d ",arr[i]);
   }
   printf("]\n");
}

void swap(int arr[],int num1, int num2) {
   int temp = arr[num1];
   arr[num1] = arr[num2];
   arr[num2] = temp;
}

int partition(int arr[],int low, int high) {
   int left,right;
   int pivotitem=arr[low];
   left=low;
   right=high;
   while(left<right){
       while(arr[left]<=pivotitem)
           left++;
       while(arr[right]>pivotitem)
           right--;
       if(left<right)
       {
           swap(arr,left,right);
       }
   }
   arr[low]=arr[right];
   arr[right]=pivotitem;
   return right;
}

void quickSort(int arr[],int low, int high) {
      int pivot;
      if(high>low)
      {
      pivot = partition(arr, low, high);
      quickSort(arr,low,pivot-1);
      quickSort(arr,pivot+1,high);
      }        
}

int main() {
   int arr[MAX] = {4,6,3,2,1,9,7};
   int i=0;
   int j=6;
   printf("Input Array: ");
   display(arr);
   printline(50);
   quickSort(arr,i,j);
   printf("Output Array: ");
   display(arr);
   printline(50);
}