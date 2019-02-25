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
		Scanner sc= new Scanner(System.in);

		int N = sc.nextInt();
		
		boolean[][] visited = new boolean[10001][10001];
		int ans =0;
		
		for(int i=0;i<N;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j=x;j<y;j++) {
				visited[j][j+1]=true;
			}
		}
		for(int i=1;i<=9999;i++) {
			if(visited[i][i+1]) {
				ans++;
			}
		}
		System.out.println(ans);
		
	}
}