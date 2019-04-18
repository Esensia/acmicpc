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
			int r1=sc.nextInt();
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			int r2=sc.nextInt();

			double dis = Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));

			if(x1==x2 && y1==y2) {
				if(r1==r2)
					System.out.println(-1);
				else 
					System.out.println(0);
			}
			else {
				if(r1+r2 > dis && Math.abs(r1-r2)<dis)
					System.out.println(2);
				else if (r1+r2 == dis || Math.abs(r1-r2)==dis)
					System.out.println(1);
				else
					System.out.println(0);
			}
		}
	}

}

