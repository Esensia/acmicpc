import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

class point{
	int x;
	int y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class Main {
	static int N=10005;
	static int[] dist = new int[N];
	static Vector<point>[] adj;
	static boolean[] selected = new boolean[N];
	
	static long prim(int pn) {
		long ret =0;
		for(int i=1;i<=pn;i++) {
			dist[i]= Integer.MAX_VALUE;
			selected[pn]= false;
		}
		dist[1]= 0;
		for(int i=1; i<=pn; i++){
	        int now=-1, min_dist = Integer.MAX_VALUE;
	        for(int j=1; j<=pn; j++){
	            if(!selected[j] && min_dist > dist[j]){
	                min_dist = dist[j];
	                now = j;
	            }
	        }
	        if(now<0) return Integer.MAX_VALUE; // 연결 그래프가 아님
	        ret+=min_dist;
	        selected[now] = true;
	        for(point edge: adj[now])
	            dist[edge.x] = Math.min(dist[edge.x], edge.y);
	    }
	    return ret;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		
		int n= sc.nextInt();
		int m= sc.nextInt();
		adj = (Vector<point>[]) new Vector[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new Vector<>();
		}
	    while(--m>=0){
	        int v1= sc.nextInt();
	        int v2= sc.nextInt();
	        int c= sc.nextInt();
	        adj[v1].add(new point(v2,c));
	        adj[v2].add(new point(v1,c));
	    }
	    System.out.println(prim(n));

	}
}