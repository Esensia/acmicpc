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
	static int pick;

	static int[][] map = new int[51][51];
	static int ans;

	static void chicken() {
		int[][] backup = new int[51][51];
		int[][] tmp = new int[51][51];
		
		int sum =0;
		for(int i=1;i<=N;i++) {
			for(int j=1; j<=N;j++) {
				backup[i][j]= map[i][j];
				if(backup[i][j]==1) {
					tmp[i][j]=1000;
				}
			}
		}

		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(backup[i][j]==2) {
					for(int r = 1; r<=N;r++) {
						for(int c=1;c<=N;c++) {
							if(backup[r][c]==1) {
								int dist = Math.abs(r-i)+Math.abs(c-j);
								if(dist<tmp[r][c]) {
									tmp[r][c]=dist;
								}
							}
						}
					}
				}
			}
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				sum+=tmp[i][j];
			}
		}
		if(ans>sum) {
			ans=sum;
		}
	}
	static void dfs(int rest, int sy, int sx) {

		if(rest == M ) {
			chicken();
		}
		for(int y = sy; y<=N; y++) {
			for(int x= sx; x <=N; x++) {
				if(map[y][x] ==2) {
					map[y][x] =0;
					dfs(rest-1, y,x);
					map[y][x]=2;
				}
			}
			sx =1;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		int rest = 0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				map[i][j]= sc.nextInt();
				if(map[i][j]==2) {
					rest++;
				}
			}
		}
		ans = Integer.MAX_VALUE;
		
		dfs(rest,1,1);
		System.out.println(ans);
	}
}