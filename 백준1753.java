import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

class pair implements Comparable<pair>{
	int first;
	int second;
	
	pair(int first, int second){
		this.first=first;
		this.second=second;
	}
	public int compareTo(pair target) {
		return this.first <= target.first ? 1 : -1;
	}
}
public class Main {
	
	static ArrayList<pair>[] adj;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();
		int K = sc.nextInt();
		PriorityQueue<pair> pq = new PriorityQueue();
		adj = (ArrayList<pair>[]) new ArrayList[20001];
		int[] d = new int[20001];
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
			d[i]=-1;
		}
		for(int i=0;i<E;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			adj[u].add(new pair(v,w));
		}
		pq.add(new pair(0,K));
		while(!pq.isEmpty()) {
			int here = pq.peek().second;
			int cost = -pq.peek().first;
			pq.poll();
			if(d[here] != -1) {
				continue;
			}
			d[here] = cost;
			for(pair it : adj[here]) {
				int next = it.first;
				int acost = -it.second - cost;
				if(d[next] != -1) {
					continue;
				}
				pq.add(new pair(acost, next));
			}
		}
		for(int i=1;i<=V;i++) {
			if(d[i]==-1) {
				System.out.println("INF");
			}
			else {
				System.out.println(d[i]);
			}
		}
	}
}