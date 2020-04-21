import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

class Point {
	int y;
	int x;
	int value;
}
public class Main {

	static int[][] map = new int[51][51];

	static int R;
	static int C;
	static int T;
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		int pos =-1;
		int time=0;
		int sum =0;
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==-1 && pos==-1) {
					pos =i;
				}
			}
		}
		
		while(time<T) {
			int[][] backup = new int[51][51];
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					backup[i][j]=map[i][j];
				}
			}
			
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(backup[i][j]!=-1 && backup[i][j]!=0) {
						int value=0;
						int count =0;
						for(int k=0;k<4;k++) {
							int y = i+dy[k];
							int x = j+dx[k];
							
							if(y<0 || y>=R || x<0 || x>=C || map[y][x]==-1) {
								continue;
							}
							count++;
							value=backup[i][j]/5;
							map[y][x]+=value;
						}
						map[i][j]-=(value*count);
					}
				}
			}
			
			int[][] backup2 = new int[51][51];
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					backup2[i][j]=map[i][j];
				}
			}
			for(int i=pos-1;i>0;i--) {
				map[i][0]=backup2[i-1][0];
			}
			for(int i=0;i<C-1;i++) {
				map[0][i]=backup2[0][i+1];
			}
			for(int i=0;i<pos;i++) {
				map[i][C-1]=backup2[i+1][C-1];
			}
			for(int i=C-1;i>1;i--) {
				map[pos][i]=backup2[pos][i-1];
			}
			map[pos][1]=0;
			
			for(int i=pos+2;i<R-1;i++) {
				map[i][0]=backup2[i+1][0];
			}
			for(int i=0;i<C-1;i++) {
				map[R-1][i]=backup2[R-1][i+1];
			}
			for(int i=R-1;i>pos+1;i--) {
				map[i][C-1]=backup2[i-1][C-1];
			}
			for(int i=C-1;i>1;i--) {
				map[pos+1][i]=backup2[pos+1][i-1];
			}
			map[pos+1][1]=0;
			
			time++;
		}
		
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) {
					sum+=map[i][j];
				}
			}
		}
		System.out.println(sum);
	}
}