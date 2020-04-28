import java.util.*;

public class Main {

	static int N;
	static int M;
	static int T;
	static int[][] map = new int[52][52];
	
	static int ans;

	public static void rotation(int x, int d, int k) {
		boolean[][] connected = new boolean[52][52];

		for(int i=x;i<=N;i+=x) {
			int[] tmp = new int[52];

			if(d==0) {
				for(int j=1;j<=M;j++) {
					if(j-k<1) {
						tmp[j]=map[i][M-k+j];
					}
					else {
						tmp[j]=map[i][j-k];
					}
				}
			}
			else {
				for(int j=1;j<=M;j++) {
					if(j+k<=M) {
						tmp[j]=map[i][j+k];
					}
					else {
						tmp[j]=map[i][j-(M-k)];
					}
				}
			}
			for(int j=1;j<=M;j++) {
				map[i][j]=tmp[j];
			}
		}
		
		
		int flag = 0;
		for(int i=1;i<=M;i++) {
			for(int j=1;j<N;j++) {
				if(map[j][i]!=0 && map[j][i]==map[j+1][i]) {
					connected[j][i]=true;
					connected[j+1][i]=true;
					flag=1;
				}
			}
		}
		for(int i=1;i<=N;i++) {
			if(map[i][1]!=0 && map[i][1]==map[i][M]) {
				connected[i][1]=true;
				connected[i][M]=true;
				flag=1;
			}
			for(int j=1;j<M;j++) {
				if(map[i][j]!=0 && map[i][j]==map[i][j+1]) {
					connected[i][j]=true;
					connected[i][j+1]=true;
					flag=1;
				}
				
			}
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(connected[i][j]) {
					map[i][j]=0;
				}
			}
		}
		
		
		if(flag==0) {
			int sum =0;
			int count =0;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=M;j++) {
					if(map[i][j]!=0) {
						sum+=map[i][j];
						count++;
					}
				}
			}
			double avg = (double)sum/count;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=M;j++) {
					if(map[i][j]!=0 && map[i][j]>avg) {
						map[i][j]--;
					}
					else if(map[i][j]!=0 && map[i][j]<avg) {
						map[i][j]++;
					}
				}
			}
		}
		
		
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				map[i][j]=sc.nextInt();
				map[i][0]+=map[i][j];
			}
			map[i][0]/=M;
		}
		// 쉬운거... 같은데??
		for(int i=0;i<T;i++) {
			int x = sc.nextInt();
			int d = sc.nextInt();
			int k = sc.nextInt();
			rotation(x,d,k);
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				ans+=map[i][j];
			}
		}
		System.out.println(ans);
	}
}
