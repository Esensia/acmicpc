import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
		String s = bf.readLine(); //String
		
		int N = Integer.parseInt(s.split(" ")[0]);
		int M = Integer.parseInt(s.split(" ")[1]);
		
		int[] A = new int[N];
		int[] B = new int[M];
		
		String str1 = bf.readLine();
		String str2 = bf.readLine();
		
		for(int i=0;i<N;i++) {
			A[i]= Integer.parseInt(str1.split(" ")[i]);
		}
		for(int i=0;i<M;i++) {
			B[i]= Integer.parseInt(str2.split(" ")[i]);
		}
		
		int idx = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			while(idx<M && A[i]>B[idx]) {
				sb.append(B[idx]);
				sb.append(" ");
				idx++;
			}
			sb.append(A[i]);
			sb.append(" ");
		}
		for(int i=idx;i<M;i++) {
			sb.append(B[i]);
			sb.append(" ");
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
}

