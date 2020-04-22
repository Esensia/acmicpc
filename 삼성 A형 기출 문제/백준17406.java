import java.util.*;

class Point{
	int r;
	int c;
	int s;

	Point(int r, int c, int s){
		this.r=r;
		this.c=c;
		this.s=s;
	}
}
public class Main {

	static int N;
	static int M;
	static int K;
	static int[][] A = new int[51][51];
	static Point[] pt = new Point[6];
	static boolean[] visited = new boolean[6];
	static LinkedList<Point> que = new LinkedList();
	static Point[] arr = new Point[6];
	static int ans;

	static void dfs(int count) {


		if(count==K) {
			cal();
			return;
		}

		for(int i=0;i<K;i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr[count]=pt[i];
				dfs(count+1);
				visited[i]=false;
			}
		}
	}

	static void cal() {
		/*
		for(int i=0;i<K;i++) {
			System.out.print("("+arr[i].r+" "+arr[i].c+" "+arr[i].s+") ");
		}
		System.out.println();
*/
		int[][] backup = new int[51][51];

		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				backup[i][j]=A[i][j];
			}
		}
		for(int i=0;i<K;i++) {
			int[][] tmp = new int[51][51];

			for(int a=1;a<=N;a++) {
				for(int b=1;b<=M;b++) {
					tmp[a][b]=backup[a][b];
				}
			}

			int upY = arr[i].r - arr[i].s;
			int upX = arr[i].c - arr[i].s;

			int downY = arr[i].r + arr[i].s;
			int downX = arr[i].c + arr[i].s;

			while(true) {

				for(int x=upX;x<=downX;x++) {
					backup[upY][x]=tmp[upY][x-1];
				}
				
				for(int y=upY+1;y<=downY;y++) {
					backup[y][downX]=tmp[y-1][downX];
				}
				
				for(int x=downX-1;x>=upX;x--) {
					backup[downY][x]=tmp[downY][x+1];
				}

				for(int y=downY-1;y>=upY;y--) {
					backup[y][upX]=tmp[y+1][upX];
				}
				
				upY++;
				upX++;
				
				downY--;
				downX--;
				
				if(upY==downY && upX == downX) {
					backup[upY][upX] = tmp[upY][upX];
					break;
				}
			}



		}
		
		for(int i=1;i<=N;i++) {
			int sum =0;
			for(int j=1;j<=M;j++) {
				sum+=backup[i][j];
			}
			if(sum<ans) {
				ans = sum;
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		ans = Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				A[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<K;i++) {
			pt[i]=new Point(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}

		dfs(0);
		System.out.println(ans);
	}
}
