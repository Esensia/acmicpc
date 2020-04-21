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
	static int H;
	static int ans;
	static int num;
	static int[][] map = new int[31][11];

	static void bfs(int count) {
		for(int j=1;j<=N;j++) {
			int start = j;
			for(int i=1;i<=H;i++) {
				if(map[i][start]==0) {
					continue;
				}
				else {

					if(map[i][start-1]==map[i][start]) {
						start--;

					}
					else if(map[i][start+1]==map[i][start]) {
						start++;

					}
				}
			}
			if(start!=j) {
				break;
			}
			if(j==N-1){
				if(ans>count) {
					ans=count;
				}
			}
		}
	}
	static void dfs(int count,int sy, int sx) {
		if(count>3) {
			return;
		}
		if(count<=3) {
			bfs(count);
		}
		for(int y = sy; y<=H;y++) {
			for(int x = sx;x<=N;x++) {
				if(x+1<=N) {
					if(map[y][x]==0 && map[y][x+1]==0) {
						num++;
						map[y][x]=num;
						map[y][x+1]=num;
						dfs(count+1,y,x);
						map[y][x]=0;
						map[y][x+1]=0;
					}
				}
			}
			sx = 1;
		}

	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		num=0;
		ans=4;
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			num++;
			map[a][b]=num;
			map[a][b+1]=num;
		}

		dfs(0,1,1);
		if(ans==4) {
			ans =-1;
		}
		System.out.println(ans);

	}
}