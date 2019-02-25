import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {

	public static BigInteger getBinom(int n, int k){
		BigInteger[][] binom = new BigInteger[n][k];
		int i, j;

		for(i=0; i<=n-1; i++){
			for(j=0; j<=(i<=k-1?i:k-1); j++){
				if(j==0 || j==i)
					binom[i][j] = BigInteger.ONE;
				else
					binom[i][j] = (binom[i-1][j-1].add(binom[i-1][j]));
			}
		}
		return binom[n-1][k-1];
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(getBinom(n,k));

	}
}