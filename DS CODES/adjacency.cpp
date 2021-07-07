//Adjacency Matrix representation!!
//code:
#include<iostream> 
#include <list> 
using namespace std; 
class Graph 
{ 
    int V;    // No. of vertices  
    list<int> *adj; 
    int matrix[100][100];
public: 
    Graph(int V);  // Constructor 
    void addEdge(int v, int w);  
    void BFS(int s); 
    void create(int v);
    void display(int v);
}; 
  
Graph::Graph(int V) 
{ 
    this->V = V; 
    adj = new list<int>[V]; 
} 
  
void Graph::addEdge(int v, int w) 
{ 
   adj[v].push_back(w); // Add w to v’s list.
   int i=v;
   int j=w;
   matrix[v][w]=1;
} 
void Graph::create(int v)
{  
    for(int i=0;i<v;i++)
    {
       for(int j=0;j<v;j++)
       {
           matrix[i][j]=0;
       }
    }
}
void Graph::display(int v)
{
   cout<<endl<<"X|";
   for(int k=0;k<v;k++)
   {
       cout<<k<<"|";
   }
   cout<<endl;
   for(int i=0;i<v;i++)
   {
       cout<<i<<"|";
       for(int j=0;j<v;j++)
       {
           cout<<matrix[i][j]<<"|";
       }
       cout<<endl;
   }
}
void Graph::BFS(int s) 
{ 
    bool *visited = new bool[V]; 
    for(int i = 0; i < V; i++) 
        visited[i] = false; 
   
    list<int> queue; 
 
    visited[s] = true; 
    queue.push_back(s); 
  
    list<int>::iterator i; 
  
    while(!queue.empty()) 
    { 
        s = queue.front(); 
        cout << s <<" "; 
        queue.pop_front(); 
  
        for (i = adj[s].begin(); i != adj[s].end(); ++i) 
        { 
            if (!visited[*i]) 
            { 
                visited[*i] = true; 
                queue.push_back(*i); 
            } 
        }
    } 
}
int main() 
{ 
    // Create a graph given in the above diagram 
    Graph g(4); 
    g.create(4);
    g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(1, 2); 
    g.addEdge(2, 0); 
    g.addEdge(2, 3); 
    g.addEdge(3, 3); 
    cout << "Following is Breadth First Traversal "
         << "(starting from vertex 2) \n"; 
    g.BFS(2); 
    g.display(4);
    return 0; 
} 