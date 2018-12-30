import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.text.*;

public class 백준2217 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] weight = new int[N];
		
		for(int i=0;i<N;i++) {
			weight[i]=sc.nextInt();
		}
		Arrays.sort(weight);
		
		int max =0;
		for(int i = N-1;i>=0;i--) {
			if(max<weight[i]*(N-i))
				max=weight[i]*(N-i);
		}
		System.out.println(max);
	}

}

