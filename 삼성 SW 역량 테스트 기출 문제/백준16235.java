import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

class Tree implements Comparable<Tree>{
	int x;
	int y;
	int age;
	@Override
	public int compareTo(Tree o) {
		// TODO Auto-generated method stub
		return this.age - o.age;
	}	
}
public class Main {

	static int[][] map = new int[11][11];
	static int[][] add = new int[11][11];
	static PriorityQueue<Tree>[] pq;
	static int N;
	static int M;
	static int K;
	static int ans;
	
	static int[] dy = {-1,-1,-1,0,1,1,1,0};
	static int[] dx = {-1,0,1,1,1,0,-1,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		pq = new PriorityQueue[2];
		pq[0] = new PriorityQueue();
		pq[1] = new PriorityQueue();
		
		int cur =0;
		int next=0;

		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				add[i][j]=sc.nextInt();
				map[i][j]=5;
			}
		}
		for(int i=0;i<M;i++) {
			Tree tree = new Tree();
			tree.y=sc.nextInt();
			tree.x=sc.nextInt();
			tree.age=sc.nextInt();
			pq[cur].add(tree);
		}
		
		for(int i=0;i<K;i++) {
			next = (cur+1)%2;
			Queue<Tree> life_tree = new LinkedList();
			Queue<Tree> dead_tree = new LinkedList();
			
			while(!pq[cur].isEmpty()) {
				Tree cur_tree = new Tree();
				cur_tree = pq[cur].poll();
				
				if(map[cur_tree.y][cur_tree.x] >= cur_tree.age) {
					map[cur_tree.y][cur_tree.x] -= cur_tree.age;
					Tree next_tree = new Tree();
					next_tree.y = cur_tree.y;
					next_tree.x = cur_tree.x;
					next_tree.age = cur_tree.age +1;
					
					life_tree.add(next_tree);
					pq[next].add(next_tree);
				}
				else {
					dead_tree.add(cur_tree);
				}
			}
			
			while(!dead_tree.isEmpty()) {
				Tree cur_tree = dead_tree.poll();
				map[cur_tree.y][cur_tree.x]+=(cur_tree.age/2);
			}
			
			while(!life_tree.isEmpty()) {
				Tree cur_tree = life_tree.poll();
				if(cur_tree.age % 5 ==0) {
					for(int dir=0;dir<8;dir++) {
						Tree next_tree = new Tree();
						next_tree.y = cur_tree.y+dy[dir];
						next_tree.x = cur_tree.x+dx[dir];
						next_tree.age =1;
						
						if(next_tree.y <1 || next_tree.y >N || next_tree.x<1 || next_tree.x>N) {
							continue;
						}
						
						pq[next].add(next_tree);
					}
				}
			}
			for(int y=1;y<=N;y++) {
				for(int x=1;x<=N;x++) {
					map[y][x] += add[y][x];
				}
			}		
			cur = next;
		}
		System.out.println(pq[next].size());
	}
}