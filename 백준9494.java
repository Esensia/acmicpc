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

		while(true) {
			int N = sc.nextInt();
			if(N==0) {
				break;
			}

			LinkedList<String> linked_str = new LinkedList();
			String tmp = sc.nextLine();
			for(int i=0;i<N;i++) {
				String str="";
				str=sc.nextLine();
				linked_str.add(str);
			}
			int altings=0;
			for(int i=0;i<N;i++) {
				String str = linked_str.get(i);

				for(int j=altings;j<str.length();j++) {
					if(str.charAt(j)==32) {
						altings=j;
						break;
					}
					if(j==str.length()-1) {
						altings=j+1;
					}
				}
			}
			if(altings==0) {
				System.out.println(0);
			}
			else {
				System.out.println(altings+1);
			}
		}

	}
}
