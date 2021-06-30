import java.io.IOException;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) throws NumberFormatException, IOException{
		// 포도주 시식

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
		}
		if(N==1) {
			dp[1]=arr[1];
		} else if(N==2) {
			dp[2] = arr[1]+arr[2];
		} else {
			dp[1]=arr[1];
			dp[2]=arr[1]+arr[2];
			for(int i=3;i<=N;i++) {
				int result = Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]);
				result = Math.max(result, dp[i-1]);
				dp[i]=result;
			}
		}
		int ans = 0;
		for(int i=1;i<=N;i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}

}

