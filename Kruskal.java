import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

class A implements Comparable<A>{
	int s;
	int e;
	int v;
	A(int s, int e, int v){
		this.s = s;
		this.e = e;
		this.v = v;
	}
	public int compareTo(A arg0) {
		return arg0.v >= this.v ? -1 : 1;
	}
}

public class Main {
	public static int find(int a) {
		if(a==parent[a]) return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}
	
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) {
			parent[aRoot] = b;
		}
		else {
			return;
		}
	}
	
	static int N;
	static int E;
	static PriorityQueue<A> pq;
	static int[] parent;
	static boolean[] visit;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.valueOf(str.split(" ")[0]);
		E = Integer.valueOf(str.split(" ")[1]);
		
		parent = new int[N+1];
		visit = new boolean[N+1];
		result =0;
		
		pq = new PriorityQueue<A>();
		String[] tempStr;
		
		for(int i=0;i<E;i++) {
			tempStr = br.readLine().split(" ");
			pq.add(new A(Integer.valueOf(tempStr[0]), Integer.valueOf(tempStr[1]),Integer.valueOf(tempStr[2])));
		}
		
		for(int i=1; i<=N;i++) {
			parent[i]= i;
		}
		
		for(int i=0;i<E;i++) {
			A oneNode = pq.poll();
			int start = oneNode.s;
			int end = oneNode.e;
			int a = find(start);
			int b = find(end);
			if(a==b)continue;
			
			union(start, end);
			result += oneNode.v;
		}
		System.out.println(result);
	}
}