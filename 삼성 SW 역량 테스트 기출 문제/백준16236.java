import java.util.*;

class Shark implements Comparable<Shark>{
	int y;
	int x;
	int size;
	int count;
	int bite;
	@Override
	public int compareTo(Shark o) {
		// TODO Auto-generated method stub
		if(this.y == o.y) {
			return this.x - o.x;
		}
		return this.y-o.y;
	}
}
public class Main {

	static int N;
	static int[][] map = new int[21][21];
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static boolean[][] visited = new boolean[21][21];
	static int ans;
	
	static void bfs() {
		Queue<Shark> que = new LinkedList();
		Shark init = new Shark();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==9) {
					init.y = i;
					init.x = j;
					init.bite =0;
					init.count =0;
					init.size = 2;
					que.add(init);
					visited[i][j]=true;
					break;
				}
			}
			if(que.size()==1) {
				break;
			}
		}
		ArrayList<Shark> arr = new ArrayList();
		int candi= Integer.MAX_VALUE;
		
		while(!que.isEmpty()) {
			Shark cur = new Shark();
			cur = que.poll();
			
			if(cur.count == candi) {
				Collections.sort(arr);
				Shark shark = new Shark();
				shark = arr.get(0);
				
				map[init.y][init.x]=0;
				map[shark.y][shark.x]=9;
				init.bite = init.bite+1;
				
				init.y = shark.y;
				init.x = shark.x;

				ans +=shark.count;

				if(init.bite == init.size) {
					init.size++;
					init.bite =0;
				}
				init.count=0;
				que.clear();
				que.add(init);

				visited = new boolean[21][21];
				visited[init.y][init.x]=true;
				arr.clear();
				candi = Integer.MAX_VALUE;
				continue;
			}
			for(int i=0;i<4;i++) {
				int y = cur.y+dy[i];
				int x = cur.x+dx[i];
				int count = cur.count +1;
				
				if(y<0|| y>=N || x<0 || x>=N) {
					continue;
				}
				if((map[y][x]==0 || map[y][x]==init.size)&& !visited[y][x]) {
					Shark next = new Shark();
					next.y = y;
					next.x = x;
					next.count = count;
					visited[y][x]=true;
					
					que.add(next);
				}
				if(map[y][x]!=0 && map[y][x]<init.size && !visited[y][x]) {
					visited[y][x]=true;
					candi = count;

					Shark next = new Shark();
					next.y = y;
					next.x = x;
					next.count = count;
					que.add(next);
					arr.add(next);
				}
			}
			
			
		}
		
	}
	
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		
		ans =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		bfs();
		System.out.println(ans);
	}
}
