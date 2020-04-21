import java.util.*;

class Point{
	int y;
	int x;
}
public class Main {

	static int N;
	static int L;
	
	static int[][] map = new int[21][21];
	
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				Point left = new Point();
				Point right = new Point();
				Point start = new Point();
				
				left.y = i;
				right.y = i;
				left.x = j;
				right.x =j;
				
				start.y = i;
				start.x = j;
				
				while(true) {
					left.y +=1;
					left.x -=1;
					
					right.y = start.y;
					right.x = start.x;
					
					if(left.y>=N || left.x <0) {
						break;
					}
					while(true) {
						right.y +=1;
						right.x +=1;
						
						if(right.y>=N || right.x>=N) {
							break;
						}
			
						Point end = new Point();
						end.y = right.y + (left.y-start.y);
						end.x = right.x -Math.abs(start.x-left.x);
						
						if(end.y >=N || end.x >= N || end.x <0) {
							continue;
						}
						int region_first = 0;
						int region_second = 0;
						int region_third = 0;
						int region_forth = 0;
						int region_fifth = 0;
						boolean[][] visited = new boolean[21][21];
						int[][] dd = new int[21][21];
						
						int boundary =0;
						
						for(int r=0;r<left.y;r++) {
							if(r>=start.y) {
								boundary++;
							}
							for(int c=0;c<=start.x-boundary;c++) {
								region_first += map[r][c];
								visited[r][c]=true;
								dd[r][c]=1;
							}
						}
						
						boundary =1;
						for(int r=0;r<=right.y;r++) {
							if(r>start.y) {
								boundary++;
							}
							for(int c=start.x+boundary;c<N;c++) {
								region_second += map[r][c];
								visited[r][c]=true;
								dd[r][c]=2;
							}
						}
						
						boundary =1;
						for(int r=N-1;r>=left.y;r--) {
							if(r<end.y) {
								boundary++;
							}
							for(int c=end.x-boundary;c>=0;c--) {
								region_third += map[r][c];
								visited[r][c]=true;
								dd[r][c]=3;
							}
						}
						
						boundary =0;
						for(int r=N-1;r>right.y;r--) {
							if(r<=end.y) {
								boundary++;
							}
							for(int c=end.x+boundary;c<N;c++) {
								region_forth += map[r][c];
								visited[r][c]=true;
								dd[r][c]=4;
							}
						}
						
						for(int r = 0;r<N;r++) {
							for(int c = 0;c<N;c++) {
								if(!visited[r][c]) {
									region_fifth+=map[r][c];
									dd[r][c]=5;
								}
							}
						}
						
						ArrayList<Integer> arr = new ArrayList();
						arr.add(region_first);
						arr.add(region_second);
						arr.add(region_third);
						arr.add(region_forth);
						arr.add(region_fifth);
						
						int ret = Collections.max(arr) - Collections.min(arr);
						
						if(ans>ret) {
							ans = ret;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
