import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.text.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] day = new int[16];
		int[] cost = new int[16];
		int[] dp = new int[16];

		for(int i=1;i<=N;i++) {
			day[i]=sc.nextInt();
			cost[i]=sc.nextInt();
			dp[i]=cost[i];
		}
		for (int i = 2; i <= N; i++) {

			for (int j = 1; j < i; j++) {

				if (i - j >= day[j]) {
					dp[i] = Math.max(cost[i] + dp[j], dp[i]);
				}

			}

		}

		int max = 0;

		for (int i = 1; i <= N; i++) {
			if (i + day[i] <= N + 1) {
				if (max < dp[i]) {
					max = dp[i];
				}
			}
		}
		System.out.println(max);
	}
}

