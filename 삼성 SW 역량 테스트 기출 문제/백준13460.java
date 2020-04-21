import java.util.*;

class Pos{
	int rx;
	int ry;
	int bx;
	int by;
	int time;
}
public class Main {

	static String[][] map = new String[11][11];
	static int N;
	static int M;
	static Pos pos;
	static boolean[][][][] visited = new boolean[11][11][11][11];
	static Queue<Pos> que = new LinkedList();
	static LinkedList<Integer> arr = new LinkedList();

	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};

	static void bfs() {

		while(!que.isEmpty()) {
			Pos cur = new Pos();
			cur = que.poll();
			if(cur.time>9) {
				break;
			}
			
			for(int i=0;i<4;i++) {

				int nbx = cur.bx;
				int nby = cur.by;
				int nrx = cur.rx;
				int nry = cur.ry;

				int flag =0;
				while(true) {
					
					if(nbx+dx[i]<0 || nbx+dx[i]>M || nby+dy[i]<0 ||nby+dy[i]>N) {
						break;
					}
					if(map[nby+dy[i]][nbx+dx[i]].equals("#")) {
						break;
					}
					if(map[nby+dy[i]][nbx+dx[i]].equals("O")) {
						flag =1;
						break;
					}
					if(map[nby+dy[i]][nbx+dx[i]].equals(".")) {
						nby += dy[i];
						nbx += dx[i];
					}
				}
				if(flag ==1) {
					continue;
				}
				while(true) {
				
					if(nrx+dx[i]<0 || nrx+dx[i]>M || nry+dy[i]<0 || nry+dy[i]>N ) {
						break;
					}
					if(map[nry+dy[i]][nrx+dx[i]].equals("#")) {
						break;
					}
					if(map[nry+dy[i]][nrx+dx[i]].equals("O")) {
						flag=1;
						break;
					}
					if(map[nry+dy[i]][nrx+dx[i]].equals(".")) {
						nry += dy[i];
						nrx += dx[i];
					}
				}
				if(nbx == nrx && nby == nry) {
					if(Math.abs(cur.bx+cur.by-nbx-nby)>Math.abs(cur.rx+cur.ry-nrx-nry)) {
						nbx -= dx[i];
						nby -= dy[i];
					}
					else {
						nrx -= dx[i];
						nry -= dy[i];
					}
				}
				int ntime = cur.time +1;

				if(flag ==1) {
					arr.add(ntime);
					break;
				}
				else {
					if(!visited[nby][nbx][nry][nrx]) {
						visited[nby][nbx][nry][nrx] =true;
						Pos next = new Pos();
						next.bx = nbx;
						next.by = nby;
						next.rx = nrx;
						next.ry = nry;
						next.time = ntime;
						que.add(next);
					}
				}
			}
		}
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		String tmp = sc.nextLine();
		pos = new Pos();
		for(int i=0;i<N;i++) {
			String str = sc.nextLine();
			String[] string = str.split("");
			for(int j=0;j<string.length;j++) {
				map[i][j]=string[j];
				if(map[i][j].equals("B")) {
					pos.by = i;
					pos.bx = j;
					map[i][j]=".";
				}
				if(map[i][j].equals("R")) {
					pos.ry = i;
					pos.rx = j;
					map[i][j]=".";
				}
			}
		}
		pos.time =0;
		que.add(pos);
		visited[pos.by][pos.bx][pos.ry][pos.rx] = true;
		bfs();
		if(arr.isEmpty()) {
			System.out.println(-1);
		}
		else {
			System.out.println(Collections.min(arr));
		}
	}
}
