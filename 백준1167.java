import java.util.ArrayList;
import java.util.Scanner;

class Node{
	int node;
	int weight;

	Node(int node, int weight){
		this.node = node;
		this.weight = weight;
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}
}
public class 백준1167 {

	static int u, r;
	static ArrayList<Node>[] adj;
	static int[] dist;
	static boolean[] visited;

	public static void dfs(int v, int d) {
		if(visited[v]) {
			dist[v] = d;
			visited[v]=false;
			if (dist[v] > r) {
				r = dist[v];
				u = v;
			}

			for (Node node : adj[v]) {
				int next = node.node;
				int weight = node.weight;

				if (dist[next] == 0) {

					dfs(next, d + weight);

				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();

		adj = (ArrayList<Node>[]) new ArrayList[100001];
		dist = new int[100001];
		visited = new boolean[100001];
		for (int i = 1; i <= 100000; i++) {
			adj[i] = new ArrayList<>();
			visited[i]=true;
		}

		for(int i=0;i<V;i++) {
			int parent = sc.nextInt();
			int child = 0;
			int weight = 0;
			boolean check = true;
			while(true) {
				for(int j =0;j<2;j++) {
					child = sc.nextInt();
					if(child == -1) {
						check = false;
						break;
					}
					weight = sc.nextInt();
					adj[parent].add(new Node(child, weight));

				}
				if(!check)
					break;
			}
		}
		
		dfs(1, 0);

		r = 0;
		dist = new int[100001];
		visited = new boolean[100001];
		for(int i=1;i<=100000;i++)
			visited[i]=true;
		
		dfs(u, 0);

		System.out.println(r);


	}
}

