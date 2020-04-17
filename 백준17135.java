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
	static int D;
	static int ans;
	static int[][] map = new int[20][20];

	private static void dfs(int count, int dx) {
		// TODO Auto-generated method stub
		if(count==3) {
			game();
			return;
		}

		for(int x=dx;x<M;x++) {
			if(map[N][x]==0) {
				map[N][x]=2;
				dfs(count+1,x);
				map[N][x]=0;
			}
		}

	}

	private static void game() {
		// TODO Auto-generated method stub

		int answer=0;
		int[][] backup = new int[20][20];

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				backup[i][j]=map[i][j];
			}
		}

		while(true) {
			int flag=1;

			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(backup[i][j]==1) {
						flag =0;
						break;
					}
				}
				if(flag==0) {
					break;
				}
			}
			if(flag==1) {
				break;
			}

			for(int i=0;i<M;i++) {
				if(map[N][i]==2) {

					for(int dis=1;dis<=D;dis++) {
						int chk=0;
						int nx = i+1-dis;
						int ny = N-1;
						while(nx <= i+dis && ny <=N-1) {
							if(nx>=0 && ny>=0 && nx<M && ny<N && (backup[ny][nx]==1 || backup[ny][nx]==3)) {
								backup[ny][nx]=3;
								chk=1;
								break;
							}
							if(dis==1) {
								break;
							}
							else {
								nx+=1;
								if(nx<i+1) {
									ny-=1;
								}
								else {
									ny+=1;
								}
								
							}

						}
						if(chk==1) {
							break;
						}

					}
				}
			}

			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(backup[i][j]==3) {
						backup[i][j]=0;
						answer++;
					}
				}
			}

			for(int i=N-1;i>=0;i--) {
				for(int j=0;j<M;j++) {
					if(backup[i][j]==1) {
						backup[i+1][j]=1;
						backup[i][j]=0;
					}
				}
			}
		}
		if(answer>ans) {
			ans = answer;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		ans = Integer.MIN_VALUE;

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=sc.nextInt();
			}
		}

		dfs(0,0);
		System.out.println(ans);

	}


}
