import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);

		int N = sc.nextInt();
		String temp = sc.nextLine();
		char[][] arr = new char[51][51];
		int[][] brr = new int[51][51];
		int max = 0;
		
		for(int i=1;i<=N;i++) {
			String str = sc.nextLine();
			for(int j=0;j<N;j++) {
				arr[i][j+1]=str.charAt(j);
				if(arr[i][j+1]=='Y') {
					brr[i][j+1]=1;
				}
				else {
					brr[i][j+1]=0;
				}
			}
			
		}
		
		for(int i=1;i<=N;i++) {
			boolean[] visited = new boolean[51];
			visited[i]=true;
			Queue<Integer> que = new LinkedList();
			int man=0;
			
			for(int j=1;j<=N;j++) {
				if(brr[i][j]==1) {
					que.add(j);
					man++;
					visited[j]=true;
				}
			}
			while(!que.isEmpty()) {
				int n = que.poll();
				for(int j=1;j<=N;j++) {
					if(brr[n][j]==1 && !visited[j]) {
						man++;
						visited[j]=true;
					}
				}
				
			}
			if(man>max) {
				max=man;
			}
			que.clear();
		}
		System.out.println(max);
	}

}
