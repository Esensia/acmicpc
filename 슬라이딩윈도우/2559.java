import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int start = 0;
		int end = 0;
		int sum = 0;
		
		int max = Integer.MIN_VALUE;
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(start=0;start<N;start++) {
			
			while(end-start<K && end < N) {
				sum += arr[end];
				end +=1;
			}
			if(end-start == K && max <sum) {
				max = sum;
			}
			sum -= arr[start];
		}
		System.out.println(max);
	}

}

