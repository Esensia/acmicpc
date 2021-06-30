import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		
		int[] arr = new int[N];
		int[] nums = new int[3001];
		int ans = 0;
		int idx = 0;
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=0;i<N;i++) {
			
			int flag = 0;
			int coupon = 1;
			idx = i;
			
			while(idx<k+i) {
				if(nums[arr[idx % N]]==1) {
					flag++;
				} else {
					nums[arr[idx % N]]=1;
				}
				
				if(arr[idx % N] == c) {
					coupon = 0;
				}
				
				idx++;
			}
		
			ans = Math.max(ans, k-flag + coupon);
			Arrays.fill(nums, 0);
		}
		System.out.println(ans);
	}
}

