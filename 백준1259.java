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
			String str = sc.nextLine();
			boolean answer = true;
			if(str.equals("0"))
				break;
			for(int i=0;i<str.length()/2;i++) {
				if(str.charAt(i)==str.charAt(str.length()-i-1)) {
					continue;
				}
				else {
					answer = false;
					break;
				}
			}
			if(answer) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
}
