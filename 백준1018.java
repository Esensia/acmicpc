import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static int ans;
	static int N;
	static int M;
	static String[] map = new String[50];
	
	static String[] type1 = {"WBWBWBWB"
							,"BWBWBWBW"
							,"WBWBWBWB"
							,"BWBWBWBW"
							,"WBWBWBWB"
							,"BWBWBWBW"
							,"WBWBWBWB"
							,"BWBWBWBW"
										};
	
	static String[] type2 = {"BWBWBWBW"
							,"WBWBWBWB"
							,"BWBWBWBW"
							,"WBWBWBWB"
							,"BWBWBWBW"
							,"WBWBWBWB"
							,"BWBWBWBW"
							,"WBWBWBWB"
										};
	
	static void draw(int y, int x) {
		int count=0;
		int a=0;
		int b=0;
		
		for(int i=y;i<y+8;i++,a++) {
			for(int j=x;j<x+8;j++,b++) {
				if(map[i].charAt(j)!=type1[a].charAt(b)) {
					count++;
	
				}
			}
			b=0;
		}
		if(count<ans) {
			ans = count;
		}
		
		count =0;
		a=0;
		b=0;
		
		for(int i=y;i<y+8;i++,a++) {
			for(int j=x;j<x+8;j++,b++) {
				if(map[i].charAt(j)!=type2[a].charAt(b)) {
					count++;
				}
			}
			b=0;
		}
		if(count<ans) {
			ans = count;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		
		ans = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			map[i]=sc.nextLine();
		}
		
		for(int i=0;i+8<=N;i++) {
			for(int j=0;j+8<=M;j++) {
				draw(i,j);
			}
		}
		System.out.println(ans);

	}

}