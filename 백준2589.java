import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.text.*;

class point{
	int x;
	int y;
}
public class 백준2589 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		String temp = sc.nextLine();
		
		
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		
		char[][] arr = new char[50][50];
		
		for(int i=0;i<a;i++) {
			String str = sc.nextLine();
			for(int j=0;j<b;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		int max =0;
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				if(arr[i][j]=='L') {
					
					point pt = new point();
					Queue<point> que = new LinkedList();
					int[][] brr = new int[50][50];
					boolean[][] visited = new boolean[50][50];
					int xx,yy;
					int x,y;
					pt.x=i;
					pt.y=j;
			
					que.add(pt);
					
					while(!que.isEmpty()) {
						point tmp = new point();
	
						tmp = que.poll();
						x=tmp.x;
						y=tmp.y;
						visited[x][y]=true;
						
						for(int k=0;k<4;k++) {
							xx=x+dx[k];
							yy=y+dy[k];
					
							if(xx<0 || yy<0 || xx>=a || yy>=b)
								continue;
							else if(arr[xx][yy]=='W')
								continue;
							if(arr[xx][yy]=='L' && !visited[xx][yy]) {
								point tmp2 = new point();
								tmp2.x=xx;
								tmp2.y=yy;
								que.add(tmp2);
								brr[xx][yy]=brr[x][y]+1;
								visited[xx][yy]= true;
							}
						}
				
						if(que.isEmpty()) {
							for(int k=0;k<a;k++) {
								for(int s=0;s<b;s++) {
									if(arr[k][s]=='L' && !visited[k][s]) {
										point tmp3 = new point();
										tmp3.x=k;
										tmp3.y=s;
										que.add(tmp3);
										break;
									}
								}
								if(que.size()==1)
									break;
							}
							
						}
				
					} 
					que.clear();
					
					for(int k=0;k<a;k++) {
						for(int s=0;s<b;s++) {
							if(brr[k][s]>max)
								max=brr[k][s];
						}
				
					}
				}

			
			}
		}
		
		System.out.println(max);

	}
}
