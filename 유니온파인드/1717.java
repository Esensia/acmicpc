import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 가장 긴 증가하는 부분수열

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N+1];
		int[] dp = new int[N+1];

		for(int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
		}

		for(int i=1;i<=N;i++) {
			dp[i]=1;
			for(int j=1; j<i;j++) {
				if(arr[i] > arr[j]) {
					if(dp[i] < dp[j]+1) {
						dp[i] = dp[j] +1;
					}
				}
			}
		}
		int max=0;
		for(int i=1;i<=N;i++)
			if(max<dp[i])
				max=dp[i];
		
		System.out.println(max);
	}
}
