import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

class Point{
	int x;
	int y;
}

public class Main {

	static int N;
	static int ans;
	static int min;
	static int max;
	static int[] nums = new int[11];
	static int[] prefix = new int[4];

	static void dfs(int result, int count) {
		if(count ==N-1) {
			if(result<min) {
				min= result;
			}
			if(result>max) {
				max = result;
			}
		}
		for(int i=0;i<4;i++) {
			if(prefix[i]!=0) {
				
				prefix[i]--;
				if(i==0) {
					dfs(result+nums[count+1],count+1);
				}
				if(i==1) {
					dfs(result-nums[count+1],count+1);
				}
				if(i==2) {
					dfs(result*nums[count+1],count+1);
				}
				if(i==3) {
					dfs(result/nums[count+1],count+1);
				}
				prefix[i]++;
			}
		}
	}
		
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		max = -Integer.MAX_VALUE;
		min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			nums[i]=sc.nextInt();
		}
		for(int i=0;i<4;i++) {
			prefix[i]=sc.nextInt();
		}
		dfs(nums[0],0);
		
		System.out.println(max);
		System.out.println(min);
	}
}