import java.util.*;

public class Main {

	static int N;
	static int[][] map = new int[21][21];
	static int[] pick = new int[21];
	static int ret;

	static void update() {
		int team1=0;
		int team2 =0; 
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				if(pick[i]==0 && pick[j]==0) {
					team1 +=map[i][j];
					team1 +=map[j][i];
				}
				else if(pick[i]==1 && pick[j]==1) {
					team2 +=map[i][j];
					team2 +=map[j][i];
				}
			}
		}
		int ans = Math.abs(team1 - team2);
		if(ret>ans) {
			ret = ans;
		}
	}
	static void dfs(int count, int si) {
		if(count==N/2) {
			update();
		}
		for(int i=si;i<N;i++) {
			if(pick[i]==1) {
				pick[i]=0;
				dfs(count+1,i+1);
				pick[i]=1;
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		ret = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			pick[i]=1;
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		dfs(0,0);
		
		System.out.println(ret);
	}
}
