import java.util.Scanner;

public class Main {

	public static int[] parent;

	public static int find(int x) {
		if(x == parent[x])
			return x;
		else 
			return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		parent[x] =y;
	}

	public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y)
            return true;
        else
            return false;
    }

	public static void main(String[] args){
		// 여행가자

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		parent = new int[201];
		
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				int num = sc.nextInt();
				if(num ==1) {
					union(i,j);
				}
			}
		}
		
		int[] visit = new int[M];
		
		for(int i=0;i<M;i++) {
			visit[i]=sc.nextInt();
		}
		
		boolean check = true;
		for(int i=0;i<M-1 && check;i++) {
			check = isSameParent(visit[i],visit[i+1]);
		}
		if(check) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}

