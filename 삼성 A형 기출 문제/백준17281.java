import java.util.*;

public class Main {

	static int[][] map = new int[50][9];
	static int N;
	static int ans;
	static boolean[] visited = new boolean[9];
	static int[] arr = new int[9];

	static void dfs(int count) {

		if(count==3) {

			visited[0]=true;
			arr[count]=0;
			dfs(count+1);
		}
		if(count==9) {
			game();
			return;
		}

		for(int i=1;i<9;i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr[count]=i;
				dfs(count+1);
				visited[i]=false;
			}
		}

	}
	static void game() {
		int score = 0;

		int tasoon = 0;
		int out =0;
		int inning = 0;

		while(inning<N) {
			int[] ru = new int[4];
			while(out<3) {
				if(tasoon==9) {
					tasoon=0;
				}
				if(map[inning][arr[tasoon]]==1) {
					if(ru[3]==1) {
						score++;
						ru[3]=0;
					}
					if(ru[2]==1) {
						ru[3]=1;
						ru[2]=0;
					}
					if(ru[1]==1) {
						ru[2]=1;
						ru[1]=0;
					}
					ru[1]=1;
					tasoon++;

				}
				else if(map[inning][arr[tasoon]]==2) {
					if(ru[3]==1) {
						score++;
						ru[3]=0;
					}
					if(ru[2]==1) {
						score++;
						ru[2]=0;
					}
					if(ru[1]==1) {
						ru[3]=1;
						ru[1]=0;
					}
					ru[2]=1;
					tasoon++;

				}
				else if(map[inning][arr[tasoon]]==3) {

					if(ru[3]==1) {
						score++;
						ru[3]=0;
					}
					if(ru[2]==1) {
						score++;
						ru[2]=0;
					}
					if(ru[1]==1) {
						score++;
						ru[1]=0;
					}
					ru[3]=1;
					tasoon++;
				}
				else if(map[inning][arr[tasoon]]==4) {

					if(ru[3]==1) {
						score++;
						ru[3]=0;
					}
					if(ru[2]==1) {
						score++;
						ru[2]=0;
					}
					if(ru[1]==1) {
						score++;
						ru[1]=0;
					}
					score++;
					tasoon++;
				}
				else if(map[inning][arr[tasoon]]==0) {
					out++;
					tasoon++;
					if(out==3) {
						out=0;
						inning++;
						ru = new int[4];
						break;
					}
				}
			}
		}

		if(score>ans) {
			ans = score;
		}
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		for(int i=0;i<N;i++) {
			for(int j=0;j<9;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		dfs(0);
		System.out.println(ans);
		
	}
}
