import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		long[] A = new long[N+1];
		
		for(int i=0;i<N;i++) {
			A[i]=sc.nextInt();
		}
		long B = sc.nextInt();
		long C = sc.nextInt();
		long people=0;
		for(int i=0;i<N;i++) {
			A[i]-=B;
			people++;
		}
		for(int i=0;i<N;i++) {
			if(A[i]>0) {
				people+=A[i]/C;
				if(A[i]%C>0) {
					people++;
				}
			}
		}
		System.out.println(people);
	}
}