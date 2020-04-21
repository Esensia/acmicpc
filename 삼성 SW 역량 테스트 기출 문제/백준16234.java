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
	static int L;
	static int R;

	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};

	static int[][] map = new int[51][51];
	static int ans;

	static void bfs() {

		while(true) {
			int flag =0;
			int[][] backup = new int[51][51];
			boolean[][] visited = new boolean[51][51];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					backup[i][j]=map[i][j];
				}
			}

			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {

					Queue<Point> que = new LinkedList();
					Point pt = new Point();
					if(!visited[r][c]) {
						pt.y = r;
						pt.x = c;
						visited[r][c]=true;
						que.add(pt);
						LinkedList<Point> points = new LinkedList();
						points.add(pt);
						while(!que.isEmpty()) {
							Point tmp = new Point();
							tmp = que.poll();
				
							for(int i=0;i<4;i++) {
								int x = tmp.x +dx[i];
								int y = tmp.y +dy[i];

								if(x<0|| y<0|| x>=N || y>=N) {
									continue;
								}
								if(Math.abs(backup[tmp.y][tmp.x]-backup[y][x])>=L && Math.abs(backup[tmp.y][tmp.x]-backup[y][x])<=R) {
									Point next = new Point();
									next.x = x;
									next.y = y;
									if(!visited[y][x]) {
										que.add(next);
										points.add(next);
										visited[y][x]=true;
									}
								}

							}
						}
						int sum=0;

						for(int i=0;i<points.size();i++) {
							sum+=backup[points.get(i).y][points.get(i).x];		
						}
						for(int i=0;i<points.size();i++) {
							map[points.get(i).y][points.get(i).x]=sum/points.size();
						}
					}
				}
			}
	
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(backup[i][j]!=map[i][j]) {
						flag=1;
						break;
					}
				}
				if(flag==1) {
					ans++;
					break;
				}
			}
			if(flag==0) {
				break;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();

		ans = 0;

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		bfs();
		System.out.println(ans);
	}
}