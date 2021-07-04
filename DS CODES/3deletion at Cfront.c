#include<stdio.h>  
#include<stdlib.h>  
void create(int);  
void beg_delete();  
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
        printf("1.Append List\n2.Delete Node from beginning\n3.Exit\n4.Enter your choice?");  
        scanf("%d",&choice);  
        switch(choice)  
        {  
            case 1:  
            printf("\nEnter the item\n");  
            scanf("%d",&item);  
            create(item);  
            break;   
            case 2:  
            beg_delete();  
            break;   
            case 3:  
            exit(0);  
            break;    
            default:  
            printf("\nPlease Enter valid choice\n");  
        }  
                  
    }while(choice != 3);  
}  
void create(int item)    
{    
        
    struct node *ptr = (struct node *)malloc(sizeof(struct node));    
    struct node *temp;  
    if(ptr == NULL)    
    {    
        printf("\nOVERFLOW");    
    }    
    else     
    {    
        ptr -> data = item;    
        if(head == NULL)    
        {    
            head = ptr;    
            ptr -> next = head;    
        }    
        else     
        {       
            temp = head;    
            while(temp->next != head)    
                temp = temp->next;    
            ptr->next = head;     
            temp -> next = ptr;     
            head = ptr;    
        }     
    printf("\nNode Inserted\n");  
    }    
                
}   
void beg_delete()  
{  
    struct node *ptr;  
    if(head == NULL)  
    {  
        printf("\nUNDERFLOW\n");      
    }  
    else if(head->next == head)  
    {  
        head = NULL;  
        free(head);  
        printf("\nNode Deleted\n");   
    }  
      
    else  
    {     
        ptr = head;   
        while(ptr -> next != head)  
            ptr = ptr -> next;   
        ptr->next = head->next;  
        free(head);  
        head = ptr->next;  
        printf("\nNode Deleted\n");   
    }  
} 