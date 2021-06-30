import java.io.IOException;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) throws NumberFormatException, IOException{
		// 계단오르

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N+1];
		int[] dp = new int[N+1];

		for(int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
		}
		if(N==1) {
			System.out.println(arr[1]);
		} else if(N==2) {
			System.out.println(arr[2]+arr[1]);
		} else {

			dp[1] = arr[1];
			dp[2] = arr[1]+arr[2];
			dp[3] = Math.max(arr[1]+arr[3], arr[2]+arr[3]);

			for(int i=4;i<=N;i++) {
				dp[i]=Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]);
			}
			System.out.println(dp[N]);
		}
	}

}

