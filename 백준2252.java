import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준2252 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		ArrayList<Integer>[] adj = new ArrayList[32001];
		Queue<Integer> que = new LinkedList();
		
		int[] indegree = new int[32001];
	

		for(int i=1;i<=N;i++) {

			adj[i] = new ArrayList<>();
			
		}

		for(int i=0;i<M;i++) {

			int question = sc.nextInt();
			int pquestion = sc.nextInt();

			adj[question].add(pquestion);
			indegree[pquestion]++;
		
	
		}
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0 ) {
				que.add(i);
			}
		}

		while(!que.isEmpty()) {
			int vertex = que.poll();
			
			System.out.print(vertex+" ");
			
			for(int there : adj[vertex]) {
				indegree[there]--;
				if(indegree[there]==0) {
					que.add(there);
				}
			}

		}

	}
}
