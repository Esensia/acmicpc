import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.text.*;

public class 백준15954 {
	
	public static double avg (int[] arr) {
		double sum =0;
		
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		return sum/arr.length;
	}
	
	public static double std (int[] arr) {
		double avg = avg(arr);
		double var=0;
		for(int i=0;i<arr.length;i++) {
			var+=(arr[i]-avg)*(arr[i]-avg);
		}
		return Math.sqrt(var/arr.length);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		double min=std(arr);
		
		while(K<=N) {
			int[] brr = new int[K];
			int i=0;
			while(K+i<=N) {
				for(int j=0;j<K;j++) {
					brr[j]=arr[j+i];
				}
				if(min>std(brr))
					min=std(brr);
				i++;
			}
			K++;
		}
		System.out.println(min);
	}
}