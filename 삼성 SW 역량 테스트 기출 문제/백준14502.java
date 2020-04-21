import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

class Point{
	int x;
	int y;
	int index;
}

public class Main {

	static int N;
	static int M;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] map = new int[8][8];
	static int ans;

	static void dfs(int count, int sy, int sx) {
		if(count ==3) {
			bfs();
			return;
		}
		for(int y = sy; y<N;y++) {
			for(int x= sx; x < M;x++) {
				if(map[y][x] ==0) {
					map[y][x] =1;
					dfs(count+1, y,x);
					map[y][x]=0;
				}
			}
			sx =0;
		}
	}
	static void bfs() {
		Queue<Point> que = new LinkedList();
		int safe=0;
		int[][] backup = new int[8][8];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				backup[i][j] = map[i][j];
			}
		}
		
		boolean[][] visited = new boolean[9][9];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(backup[i][j]==2) {
					Point pt = new Point();
					pt.x = j;
					pt.y = i;
					que.add(pt);
				}
			}
		}
		while(!que.isEmpty()) {
			Point tmp = new Point();
			tmp = que.poll();
			visited[tmp.y][tmp.x] = true;

			for(int i=0;i<4;i++) {
				int x = tmp.x+dx[i];
				int y = tmp.y+dy[i];

				if(x>=0 && y>=0 && x <M && y<N) {
					if(backup[y][x]==0 && !visited[y][x]) {
						backup[y][x]=2;
						Point virus = new Point();
						virus.x = x;
						virus.y = y;
						que.add(virus);
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(backup[i][j]==0) {
					safe++;
				}
			}
		}
		if(safe>ans) {
			ans=safe;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		
		ans =0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		dfs(0,0,0);
		System.out.println(ans);
	}
}