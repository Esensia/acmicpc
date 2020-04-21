import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static int[][] map = new int[9][9];
	static int[][] rot = new int[9][9];
	static int ans;
	static int tt;
	static int N;
	static int M;

	static void bfs() {
		int[][] backup = new int[9][9];
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				backup[i][j]=map[i][j];
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(backup[i][j]==1 && rot[i][j]==4) {
					for(int x=j+1;x<M;x++) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
				}
				if(backup[i][j]==1 && rot[i][j]==3) {
					for(int y=i+1;y<N;y++) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
				}
				if(backup[i][j]==1 && rot[i][j]==2) {
					for(int x=j-1;x>=0;x--) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
				}
				if(backup[i][j]==1 && rot[i][j]==1) {
					for(int y=i-1;y>=0;y--) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
				}
				if(backup[i][j]==2 && (rot[i][j]==4 || rot[i][j]==2)) {
					for(int x=j-1;x>=0;x--) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
					for(int x=j+1;x<M;x++) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
				}
				if(backup[i][j]==2 && (rot[i][j]==3 || rot[i][j]==1)) {
					for(int y=i-1;y>=0;y--) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
					for(int y=i+1;y<N;y++) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
				}
				if(backup[i][j]==3 && rot[i][j]==4 ) {
					for(int y=i-1;y>=0;y--) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
					for(int x=j+1;x<M;x++) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
				
				}
				if(backup[i][j]==3 && rot[i][j]==3) {
					for(int x=j+1;x<M;x++) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
					for(int y=i+1;y<N;y++) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
				}
				if(backup[i][j]==3 && rot[i][j]==2) {
					for(int x=j-1;x>=0;x--) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
					for(int y=i+1;y<N;y++) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
				}
				if(backup[i][j]==3 && rot[i][j]==1) {
					for(int x=j-1;x>=0;x--) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
					for(int y=i-1;y>=0;y--) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
				}
				if(backup[i][j]==4 && rot[i][j]==4) {
					for(int x=j-1;x>=0;x--) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
					for(int y=i-1;y>=0;y--) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
					for(int x=j+1;x<M;x++) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
				}
				if(backup[i][j]==4 && rot[i][j]==3) {
					for(int y=i-1;y>=0;y--) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
					for(int x=j+1;x<M;x++) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
					for(int y=i+1;y<N;y++) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
				}
				if(backup[i][j]==4 && rot[i][j]==2) {
					for(int x=j+1;x<M;x++) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
					for(int y=i+1;y<N;y++) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
					for(int x=j-1;x>=0;x--) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
				}
				if(backup[i][j]==4 && rot[i][j]==1) {
					for(int y=i+1;y<N;y++) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
					for(int x=j-1;x>=0;x--) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
					for(int y=i-1;y>=0;y--) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
				}
				if(backup[i][j]==5) {
					for(int y=i+1;y<N;y++) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
					for(int x=j-1;x>=0;x--) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
					for(int y=i-1;y>=0;y--) {
						if(backup[y][j]==0) {
							backup[y][j]=-1;
						}
						if(backup[y][j]==6) {
							break;
						}
					}
					for(int x=j+1;x<M;x++) {
						if(backup[i][x]==0) {
							backup[i][x]=-1;
						}
						if(backup[i][x]==6) {
							break;
						}
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(backup[i][j]==0) {
					count++;
				}
			}
		}
		if(count<ans) {
			ans=count;
		}
	}
	static void dfs(int sy, int sx) {
		bfs();
		for(int y=sy;y<N;y++) {
			for(int x=sx;x<M;x++) {
				if(rot[y][x]!=1 && rot[y][x]!=0) {
					rot[y][x]--;
					dfs(y,x);
					rot[y][x]++;
				}
			}
			sx=0;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		tt=1;
		N = sc.nextInt();
		M = sc.nextInt();
		ans = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]>=1 && map[i][j]<=5) {
					rot[i][j]=4;
				}
			}
		}

		dfs(0,0);
		System.out.println(ans);

	}
}