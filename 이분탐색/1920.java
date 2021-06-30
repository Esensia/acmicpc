import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] A = new int[N];
		
		for(int i=0;i<N;i++)
			A[i]=sc.nextInt();
		Arrays.sort(A);
		int M = sc.nextInt();
		
		while(--M>=0) {
			int num=sc.nextInt();
			int checker=0;
			int left = 0;
			int right = A.length-1;
			
			while(left<=right) {
				int mid = (left + right)/2;
				if(num > A[mid])
					left = mid +1;
				else if (num < A[mid])
					right = mid -1;
				else
				{
					checker=1;
					break;
				}
			}
			System.out.println(checker);
		}
		
		
	}
	
}

