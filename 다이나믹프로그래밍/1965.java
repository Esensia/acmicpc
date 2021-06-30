import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// 상자에 넣기

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[1001];
		int[] dp = new int[1001];
		
		for(int i=1;i<=N;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1;i<=N;i++) {
			dp[i] = 1;
			for(int j=1;j<i;j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
		}
		
		int ans = Integer.MIN_VALUE;
		
		for(int i=1;i<=N;i++) {
			ans = Math.max(ans,dp[i]);
		}
		
		System.out.println(ans);
	}

}