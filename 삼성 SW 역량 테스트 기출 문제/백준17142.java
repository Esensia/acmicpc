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
}

public class Main {

	static int N;
	static int M;
	static int ans;
	static int[][] map = new int[51][51];

	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};

	static void bfs() {
		Queue<Point> que = new LinkedList();

		int[][] backup = new int[51][51];
		boolean[][] visited = new boolean[51][51];
		boolean[][] blank = new boolean[51][51];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==0) {
					blank[i][j]=true;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				backup[i][j]=map[i][j];
				if(map[i][j]==-3) {
					Point pt = new Point();
					pt.y = i;
					pt.x = j;
					que.add(pt);
					visited[i][j]=true;
					backup[i][j]=0;
				}
			}
		}

		while(!que.isEmpty()) {

			Point tmp = new Point();
			tmp = que.poll();

			for(int i=0;i<4;i++) {
				int x = tmp.x+dx[i];
				int y = tmp.y+dy[i];

				if(x<0 || x>=N || y<0 || y>=N)
					continue;
				if(backup[y][x]==0 && !visited[y][x]) {
					backup[y][x]=backup[tmp.y][tmp.x]+1;
					Point pt = new Point();
					pt.x =x;
					pt.y =y;
					que.add(pt);
					visited[y][x]=true;
				}
				if(backup[y][x]==-2 && !visited[y][x]) {
					backup[y][x]=backup[tmp.y][tmp.x]+1;
					Point pt = new Point();
					pt.x = x;
					pt.y = y;
					que.add(pt);
					visited[y][x]=true;
				}
			}
		}
		int zerosum=0;
		int flag=0;
		int max =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(backup[i][j]==0) {
					zerosum++;
				}
				if(backup[i][j]>max && blank[i][j]) {
					max=backup[i][j];
				}
			}

		}
		int ret=0;
		if(zerosum==M) {
			if(ans>max) {
				ans=max;
			}
		}
	}

	static void dfs(int count, int sy, int sx) {
		if(count==M) {
			bfs();
			return;
		}
		for(int y=sy ; y<N;y++) {
			for(int x=sx; x<N;x++) {
				if(map[y][x]==-2){
					map[y][x]=-3;
					dfs(count+1,y,x);
					map[y][x]=-2;
				}
			}
			sx=0;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		ans = Integer.MAX_VALUE;

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==1) {
					map[i][j]=-1;
				}
				if(map[i][j]==2) {
					map[i][j]=-2;
				}
			}
		}
		dfs(0,0,0);
		if(ans==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
	}
}