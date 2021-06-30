import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int lowerBound(int[] array,  int value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            final int mid = low + (high - low)/2;
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
	
	public static int upperBound(int[] array, int value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            final int mid = low + (high - low)/2;
            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }



	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(bf.readLine());
		
		String[] str = bf.readLine().split(" ");
		
		int[] nums = new int[N];
		
		for(int i=0;i<str.length;i++) {
			nums[i] = Integer.parseInt(str[i]);
		}
		Arrays.sort(nums);

		int M = Integer.parseInt(bf.readLine());
		
		str = bf.readLine().split(" ");
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<str.length;i++) {
			int num = Integer.parseInt(str[i]);
			
			sb.append(String.valueOf(upperBound(nums,num) - lowerBound(nums,num))+" ");
		}
		
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
}

