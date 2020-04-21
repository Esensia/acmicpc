import java.util.*;

class Point{
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
	int y;
	int x;
}
public class Main {

	static int[][] map = new int[10][10];
	static int[] size = {0,1,2,3,4};
	static int[] paper = {5,5,5,5,5};
	static int ans =Integer.MAX_VALUE;
	static LinkedList<Point> que = new LinkedList();

	static void dfs(int count, int y, int x) {

		boolean allZero=true;

		for(int i=0; allZero && i<10;i++) {
			for(int j=0;j<10;j++) {
				if(map[i][j]==1) {
					allZero = false;
					break;
				}
			}
		}
		if(allZero) {
			if(count<ans) {
				ans = count;
			}
			return;
		}
		if(count==26) {
			ans=-1;
			return;
		}


		for(int i=4;i>=0;i--) {
			if(allOne(y,x,size[i]) && paper[size[i]]>0) {
				visit(y,x,size[i],0);
				paper[size[i]]--;
				//
				int dy = y;
				int dx = x;
				int flag = 0;
				for(int j=0;j<10;j++) {
					for(int k=0;k<10;k++) {
						if(map[j][k]==1) {
							dy=j;
							dx=k;
							flag =1;
							break;
						}
					}
					if(flag==1)
						break;
				}
				//
				dfs(count+1,dy,dx);
				visit(y,x,size[i],1);
				paper[size[i]]++;
			}
		}

	}

	private static void visit(int y, int x, int length, int value) {

		for(int i=y;i<=y+length;i++) {
			for(int j=x;j<=x+length;j++) {
				map[i][j]=value;
			}
		}
	}

	private static boolean allOne(int y, int x, int length) {

		if(y+length>=10 || x+length>=10) {
			return false;
		}
		for(int i=y;i<=y+length;i++) {
			for(int j=x;j<=x+length;j++) {
				if(map[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==1) {
					que.add(new Point(i,j));
				}
			}
		}
		if(que.isEmpty()) {
			System.out.println(0);
		}
		else {
			dfs(0,que.get(0).y, que.get(0).x);
			if(ans==Integer.MAX_VALUE) {
				ans = -1;
			}
			System.out.println(ans);
		}
	}
}
