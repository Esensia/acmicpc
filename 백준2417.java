import java.math.BigDecimal;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);

		long n = sc.nextLong();
		BigDecimal big = new BigDecimal(Math.ceil(Math.sqrt(n)));
		System.out.println(big.toString());
	}
}