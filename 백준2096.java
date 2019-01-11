import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 백준2096 {
	
	static int[][] dpa = new int[100001][4];
	static int[][] dpi = new int[100001][4];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] arr = new int[100001][4];
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=3;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		for(int i=1;i<=N;i++) {
			dpa[i][1] = Math.max(dpa[i-1][1], dpa[i-1][2])+arr[i][1];
			dpa[i][2] = Math.max(dpa[i-1][1], Math.max(dpa[i-1][2], dpa[i-1][3]))+arr[i][2];
			dpa[i][3] = Math.max(dpa[i-1][2], dpa[i-1][3])+arr[i][3];
			
			dpi[i][1] = Math.min(dpi[i-1][1], dpi[i-1][2])+arr[i][1];
			dpi[i][2] = Math.min(dpi[i-1][1], Math.min(dpi[i-1][2], dpi[i-1][3]))+arr[i][2];
			dpi[i][3] = Math.min(dpi[i-1][2], dpi[i-1][3])+arr[i][3];
		}
		max = Math.max(dpa[N][1],Math.max(dpa[N][2], dpa[N][3]));
		min = Math.min(dpi[N][1],Math.min(dpi[N][2], dpi[N][3]));
		
		System.out.println(max+" "+min);
	}
}
