import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	public static int time[];
	public static int maxtime[];
	public static int N,K,W;
	
	public static LinkedList<Integer> graph[];
	public static int n, indegree[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		int result[] = new int[T];
		
		for(int t=0;t<T;t++) {
			N=scan.nextInt();
			K=scan.nextInt();
			
			time = new int[N];
			maxtime = new int[N];
			indegree = new int[N];
			graph = new LinkedList[N];
			
			for(int i=0;i<N;i++) {
				time[i] = scan.nextInt();
				graph[i] = new LinkedList<>();
			}
			
			int from, to;
			for(int i=0;i<K;i++) {
				from = scan.nextInt()-1;
				to = scan.nextInt()-1;
				graph[from].add(to);
				indegree[to]++;
			}
			
			W = scan.nextInt()-1;
			topologicalSort();
			
			result[t]=maxtime[W];
		}
		for(int i : result)
			System.out.println(i);
	}

	private static void topologicalSort() {
		// TODO Auto-generated method stub
		Queue<Integer> searchQ = new LinkedList<Integer>();
		
		for(int i=0;i<N;i++) {
			if(indegree[i]==0) {
				searchQ.offer(i);
				maxtime[i]=time[i];
			}
		}
		while(!searchQ.isEmpty() && indegree[W]!=0) {
			int zeroNode = searchQ.poll();
			for(int linkedNode : graph[zeroNode]) {
				if(maxtime[zeroNode]+time[linkedNode]>maxtime[linkedNode])
					maxtime[linkedNode]=time[zeroNode]+time[linkedNode];
				
				indegree[linkedNode]--;
				
				if(indegree[linkedNode]==0) {
					searchQ.offer(linkedNode);
					time[linkedNode]=maxtime[linkedNode];
				}
			}
			
		}
		
	}	
}