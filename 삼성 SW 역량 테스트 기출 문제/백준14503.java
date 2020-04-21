import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static int r;
	static int c;
	static int d;

	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();

		int[][] map = new int[N+1][M+1];
		boolean[][] visited = new boolean[N+1][M+1];
		int clear = 0;

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=sc.nextInt();

			}
		}
		clear++;
		int rot=0;
		visited[r][c] = true;
		while(true) {
			int nextx = c +dx[(d+3)%4];
			int nexty = r +dy[(d+3)%4];
			rot++;
			
			if(map[nexty][nextx] ==0 && !visited[nexty][nextx]) {
				c = nextx;
				r = nexty;
				visited[nexty][nextx] =true;
				clear++;
				d = (d+3)%4;
				rot=0;
			}
			else if((map[nexty][nextx] == 0 && visited[nexty][nextx]) || map[nexty][nextx]==1) {
				d = (d+3)%4;
			}
		
			if(rot==4) {
				int backx = c-dx[d];
				int backy = r-dy[d];
				if(map[backy][backx] != 1 ) {
					c = backx;
					r = backy;
					rot=0;
				}
				else {
					break;
				}
			}


		}
		System.out.println(clear);
	}
}