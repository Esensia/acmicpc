import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		Stack<Long> st = new Stack();
		ArrayList<Long> arr = new ArrayList();
		for(long i=1;i<=Math.sqrt(N);i++) {
			if(N%i==0) {
				st.push(i);
				arr.add(i);
			}
		}
		long num = st.peek();
		if(num*num==N) {
			st.pop();
		}
		while(!st.isEmpty()) {
			long a = st.pop();
			arr.add(N/a);
		}
		if(arr.size()%2==1) {
			System.out.println(0);
		}
		else {
			System.out.println(arr.get(arr.size()/2)-arr.get(arr.size()/2-1));
		}
	}
}