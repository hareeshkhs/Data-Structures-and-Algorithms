
//bubble short
void bubble(int n){
for(i=0;i<n-1;i++)
{
    for(j=0;j<n-i-1;j++)
    {
        if(arr[j]>arr[j+1])
        {
            temp=arr[j];
            arr[j]=arr[j+1];
            arr[j+1]=temp;
        }
    }
}
}
//selection short
void selection(int n){
for(i=0;i<n-1;i++)
{
    min=i;
    for(j=i+1;j<n;j++)
    {
        if(arr[j]<arr[min])
        {
             min=j;
        }
    }
            temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
}
}
//insertion short
void insertion(int n)
{
int i,j,key;
for(i=1;i<=n-1;i++)
{
    key=arr[i];
    j=i;
    while(arr[j-1]>key&& j>0){
        arr[j]=arr[j-1];
        j--;
    }
    arr[j]=key;
}
}