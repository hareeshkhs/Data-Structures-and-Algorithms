#include<stdio.h>  
#include<stdlib.h>  
void create(int);  
void delete_specified();  
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
        printf("1.Append List\n2.Delete node\n3.Exit\n4.Enter your choice?");  
        scanf("%d",&choice);  
        switch(choice)  
        {  
            case 1:  
            printf("\nEnter the item\n");  
            scanf("%d",&item);  
            create(item);  
            break;   
            case 2:  
            delete_specified();  
            break;   
            case 3:  
            exit(0);  
            break;    
            default:  
            printf("\nPlease enter valid choice\n");  
        }  
                  
    }while(choice != 3);  
}  
void create(int item)  
{  
   struct node *ptr = (struct node *)malloc(sizeof(struct node));  
   if(ptr == NULL)  
   {  
       printf("\nOVERFLOW\n");  
   }  
   else  
   {  
      
      
   if(head==NULL)  
   {  
       ptr->next = NULL;  
       ptr->prev=NULL;  
       ptr->data=item;  
       head=ptr;  
   }  
   else   
   {  
       ptr->data=item;  
       ptr->prev=NULL;  
       ptr->next = head;  
       head->prev=ptr;  
       head=ptr;  
   }  
    printf("\nNode Inserted\n");  
}  
     
}  
void delete_specified( )  
{  
    struct node *ptr, *temp;   
    int val;   
    printf("Enter the value");  
    scanf("%d",&val);  
    temp = head;  
    while(temp -> data != val)  
    temp = temp -> next;  
    if(temp -> next == NULL)  
    {  
        printf("\nCan't delete\n");  
    }  
    else if(temp -> next -> next == NULL)  
    {  
        temp ->next = NULL;  
        printf("\nNode Deleted\n");  
    }  
    else  
    {   
        ptr = temp -> next;  
        temp -> next = ptr -> next;  
        ptr -> next -> prev = temp;  
        free(ptr);  
        printf("\nNode Deleted\n");  
    }     
}  