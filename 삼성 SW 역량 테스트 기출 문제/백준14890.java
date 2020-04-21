import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static int[][] map = new int[101][101];
	static int N;
	static int L;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		L = sc.nextInt();
		int count =0;

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();

			}
		}
		for(int i=0;i<N;i++) {
			boolean[] visited = new boolean[N];
			int flag=0;
			for(int j=0;j<N-1;j++) {
				if(Math.abs(map[i][j]-map[i][j+1])>=2) {
					flag=1;
					break;
				}
				if((map[i][j]-map[i][j+1])==1) {
					int height = map[i][j+1];
					flag=0;
					for(int k=j+1;k<=L+j;k++) {
						
						if(k>=N) {
							flag=1;
							break;
						}
						visited[k]=true;
						if(height!=map[i][k]) {
							flag=1;
							break;
						}
						if(k==L+j) {
							j=k-1;
							break;
						}
					}
					if(flag==1) {
						break;
					}
				}
				if((map[i][j]-map[i][j+1])==-1) {
					int height = map[i][j];
					flag=0;
					if(i==3) {
					}
					for(int k=j;k>j-L;k--) {
						if(i==3) {
						}
						if(k<0 || visited[k]) {
							flag=1;
							break;
						}
						if(height!=map[i][k]) {
							flag=1;
							break;
						}
					
					}
					if(flag==1) {
						break;
					}
				}

			}
			if(flag==0) {
				count++;
			}
		}
		
		for(int i=0;i<N;i++) {
			boolean[] visited = new boolean[N];
			int flag=0;
			for(int j=0;j<N-1;j++) {
				if(Math.abs(map[j][i]-map[j+1][i])>=2) {
					flag=1;
					break;
				}
				if((map[j][i]-map[j+1][i])==1) {
					int height = map[j+1][i];
					flag=0;
					for(int k=j+1;k<=L+j;k++) {
						
						if(k>=N) {
							flag=1;
							break;
						}
						visited[k]=true;
						if(height!=map[k][i]) {
							flag=1;
							break;
						}
						if(k==L+j) {
							j=k-1;
							
							break;
						}
					}
					if(flag==1) {
						break;
					}
				}
				if((map[j][i]-map[j+1][i])==-1) {
					int height = map[j][i];
					flag=0;
					for(int k=j;k>=j-L+1;k--) {
						if(k<0 || visited[k]) {
							flag=1;
							break;
						}
						if(height!=map[k][i]) {
							flag=1;
							break;
						}
					}
					if(flag==1) {
						break;
					}
				}

			}
			if(flag==0) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}