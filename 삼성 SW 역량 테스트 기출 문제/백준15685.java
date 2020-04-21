import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int count =0;
		int[][] ans = new int[101][101];
		
		int N = sc.nextInt();
		
		
		for(int i=0;i<N;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			
			int dx =0;
			int dy =0;
			
			int[][][] arr = new int[g+1][101][101];
			
			arr[0][y][x] = 1;
			
			if(d == 0) {
				arr[0][y][x+1]=1;
				dx = x+1;
				dy = y;
			}
			else if(d== 1) {
				arr[0][y-1][x]=1;
				dx = x;
				dy = y-1;
			}
			else if(d== 2) {
				arr[0][y][x-1]=1;
				dx = x-1;
				dy = y;
				
			}
			else {
				arr[0][y+1][x]=1;
				dx = x;
				dy = y+1;
			}
			
			for(int n = 0; n<g ; n++) {
				int[][] cur = new int[101][101];
				
				for(int c=0; c<101; c++) {
					for(int r=0;r<101;r++) {
						if(!(r==dx && c==dy) && arr[n][c][r]!=0) {
							cur[-dx+dy+r][dx+dy-c]=arr[n][c][r];
						}
						arr[n+1][c][r] = arr[n][c][r];
					}
				}
				
				for(int c=0;c<101;c++) {
					for(int r=0;r<101;r++) {
						arr[n+1][c][r] += cur[c][r];
					}
				}
				int tmpx = dx;
				int tmpy = dy;
				dx = tmpx+tmpy-y;
				dy = -tmpx+tmpy+x;
			}
			for(int c=0;c<101;c++) {
				for(int r=0; r<101; r++) {
					ans[c][r]+=arr[g][c][r];
				}
			}
		}
		for(int i=0;i<101;i++) {
			for(int j=0 ; j<101;j++) {
				if(j<100 && i <100) {
					if(ans[i][j]!=0 && ans[i+1][j]!=0 && ans[i][j+1]!=0 && ans[i+1][j+1]!=0) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}