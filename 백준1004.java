import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.text.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while(--T>=0) {
			int x1= sc.nextInt();
			int y1=sc.nextInt();
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			int n = sc.nextInt();
			
			int count=0;
			
			for(int i=0;i<n;i++) {
				int cx = sc.nextInt();
				int cy = sc.nextInt();
				int r = sc.nextInt();
				
				if((cx-x1) * (cx-x1) + (cy-y1) * (cy-y1) >=r*r || (cx-x2) * (cx-x2) + (cy-y2) * (cy-y2) >=r*r ) {
					if((cx-x1) * (cx-x1) + (cy-y1) * (cy-y1) <r*r)
						count++;
					if((cx-x2) * (cx-x2) + (cy-y2) * (cy-y2) <r*r)
						count++;
				}
			}
			System.out.println(count);
		
		}
	}

}

