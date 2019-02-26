import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static int[] snack;
	static int N;
	static int M;
	static boolean possible(int len) {
		int cnt =0;
		for(int i=0;i<N;i++) {
			cnt +=snack[i]/len;
		}
		if(cnt>=M) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		snack = new int[N];
		int ans =0;
		int low=1;
		int high=0;
		for(int i=0;i<N;i++) {
			snack[i]=sc.nextInt();
			if(high<snack[i]) {
				high = snack[i];
			}
		}
		while(low<=high) {
			int mid = (low+high)/2;
			if(possible(mid)) {
				ans = mid;
				low = mid +1;
			}
			else {
				high = mid -1;
			}
		}
		System.out.println(ans);
		
	}
}