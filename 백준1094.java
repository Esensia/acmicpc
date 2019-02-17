import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.text.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		int X = scan.nextInt();
		int count=0;
		int sum =0;
		int stick=64;
		int X1=X;
		while(X!=sum) {
			while(X1<stick)
				stick=stick/2;
			sum+=stick;
			X1=X1-stick;
			count++;
			
		}
		System.out.println(count);
	}
}