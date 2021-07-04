#include<stdio.h>  
#include<stdlib.h>  
void create(int);  
void delete_specified();  
struct node  
{  
    int data;  
    struct node *next;  
};  
struct node *head;  
void main ()  
{  
    int choice,item;  
    do   
    {  
        printf("\n1.Append List\n2.Delete node\n3.Exit\n4.Enter your choice?");  
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
        struct node *ptr = (struct node *)malloc(sizeof(struct node *));  
        if(ptr == NULL)  
        {  
            printf("\nOVERFLOW\n");  
        }  
        else  
        {  
            ptr->data = item;  
            ptr->next = head;  
            head = ptr;  
            printf("\nNode inserted\n");  
        }  
          
    }  
void delete_specified()  
    {  
        struct node *ptr, *ptr1;  
        int loc,i;   
        scanf("%d",&loc);  
        ptr=head;  
        for(i=0;i<loc;i++)  
        {  
            ptr1 = ptr;       
            ptr = ptr->next;  
              
            if(ptr == NULL)  
            {  
                printf("\nThere are less than %d elements in the list..\n",loc);  
                return;  
            }  
        }  
        ptr1 ->next = ptr ->next;  
        free(ptr);  
        printf("\nDeleted %d node ",loc);  
    }     