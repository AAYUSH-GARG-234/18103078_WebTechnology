import java.util.*; 
 
class quest3 
{ 
	class Edges 
	{ 
		int source, destination, w; 
		Edges() 
		{ 
			source = 0;
			destination = 0;
			w = 0; 
		} 
	}; 

	int V, E; 
	Edges edges[]; 

	question3(int v, int e) 
	{ 
		V = v; 
		E = e; 
		edges = new Edges[e]; 
		for (int i = 0; i < e; ++i) 
			edges[i] = new Edges(); 
	} 
	
	void BellmanFord(question3 graph, int source) 
	{ 
		int V = graph.V, E = graph.E; 
		int dist[] = new int[V]; 

		for (int i = 0; i < V; ++i) 
			dist[i] = Integer.MAX_VALUE; 
		dist[source] = 0; 

		for (int i = 1; i < V; ++i) 
		{ 
			for (int j = 0; j < E; ++j) 
			{ 
				int u = graph.edges[j].source; 
				int v = graph.edges[j].destination; 
				int w = graph.edges[j].w; 
				if (dist[u]!= Integer.MAX_VALUE && dist[u]+w<dist[v])
				{
					dist[v]=dist[u]+w;
				}
			} 
		} 

		for (int j = 0; j < E; ++j) 
		{ 
			int u = graph.edges[j].source; 
			int v = graph.edges[j].destination; 
			int w = graph.edges[j].w; 
			if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) 
			{ 
				System.out.println("Negative cycles Exist"); 
				return; 
			} 
		} 
		printArr(dist, V); 
	} 

	void printArr(int dist[], int V) 
	{ 
		System.out.println("Vertex Distance from Source"); 
		for (int i = 0; i < V; ++i) 
			System.out.println(i + "\t\t" + dist[i]); 
	} 

	public static void main(String[] args) 
	{ 
		Scanner input=new Scanner(System.in);
		System.out.println("Enter no. of vertices:");
		int V = input.nextInt();
		System.out.println("Enter no. of edges:");
		int E = input.nextInt();  

		question3 graph = new question3(V, E); 
		System.out.println("Enter the source vertex, destination vertex and w of each edges:");
		for(int i=0;i<E;i++)
		{
			graph.edges[i].source = input.nextInt(); 
			graph.edges[i].destination = input.nextInt(); 
			graph.edges[i].w = input.nextInt();
		}
		input.close();
		graph.BellmanFord(graph, 0); 
	} 
} 
