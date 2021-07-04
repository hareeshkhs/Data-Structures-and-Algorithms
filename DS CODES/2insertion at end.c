#include<stdio.h>  
#include<stdlib.h>  
void insertlast(int);  
struct node  
{  
    int data;  
    struct node *next;  
    struct node *prev;  
};  
struct node *head;  
void main ()  
{  
    int choice,item;  
    do   
    {  
        printf("\nEnter the item which you want to insert?\n");  
        scanf("%d",&item);  
        insertlast(item);  
        printf("\nPress 0 to insert more ?\n");  
        scanf("%d",&choice);  
    }while(choice == 0);  
}  
void insertlast(int item)  
{  
    
   struct node *ptr = (struct node *) malloc(sizeof(struct node));  
   struct node *temp;  
   if(ptr == NULL)  
   {  
       printf("\nOVERFLOW");  
          
   }  
   else  
   {  
       
        ptr->data=item;  
       if(head == NULL)  
       {  
           ptr->next = NULL;  
           ptr->prev = NULL;  
           head = ptr;  
       }  
       else  
       {  
          temp = head;  
          while(temp->next!=NULL)  
          {  
              temp = temp->next;  
          }  
          temp->next = ptr;  
          ptr ->prev=temp;  
          ptr->next = NULL;  
       }  
printf("\nNode Inserted\n");  
             
   }  
}  