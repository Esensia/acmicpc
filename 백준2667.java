import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.text.*;

class pos{
	int x;
	int y;
}
public class 백준2667 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		Deque<pos> que = new LinkedList();
		ArrayList<Integer> cnt = new ArrayList();
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};

		int x,y,xx,yy;
		int count=1;

		int[][] arr = new int[25][25];
		boolean[][] visited = new boolean[25][25];

		int N = sc.nextInt();
		String tempstr = sc.nextLine();
		for(int i=0;i<N;i++) {
			String str = sc.nextLine();
			for(int j=0;j<N;j++) {
				arr[i][j]=str.charAt(j)-'0';

			}
		}
		pos a = new pos();

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==1) {
					a.x=i;
					a.y=j;
					que.add(a);
					break;
				}
			}
			if(que.size()==1)
				break;
		}
		while(!que.isEmpty()) {

			pos temp = new pos();
			temp=que.poll();

			x=temp.x;
			y=temp.y;
			visited[x][y]=true;

			for(int i=0;i<4;i++) {
				xx= x+dx[i];
				yy= y+dy[i];

				if(xx<0 || xx>=N || yy<0 || yy>=N)
					continue;
				else if(arr[xx][yy]==0)
					continue;
				if(arr[xx][yy]==1 && visited[xx][yy]==false) {
					count++;
					pos xy = new pos();
					xy.x=xx;
					xy.y=yy;
					que.add(xy);
					visited[xx][yy]=true;
					arr[xx][yy]=count;
				}
			}
			if(que.size()==0) {
				cnt.add(count);
				count=1;
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(arr[i][j]==1 && visited[i][j]==false) {
							a.x=i;
							a.y=j;
							que.add(a);
							break;
						}
					}
					if(que.size()==1)
						break;
				}
				
			}
			
		}
		Collections.sort(cnt);
		System.out.println(cnt.size());
		for(int i=0;i<cnt.size();i++)
			System.out.println(cnt.get(i));
	}
}
