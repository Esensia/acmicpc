import java.util.*;

public class 백준1049 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int min = Integer.MAX_VALUE;

		ArrayList<Integer> pack = new ArrayList();
		ArrayList<Integer> num = new ArrayList();
		ArrayList<Integer> ans = new ArrayList();

		for(int i=0;i<M;i++) {
			pack.add(sc.nextInt());
			num.add(sc.nextInt());
		}

		int pack1 = Collections.min(pack);
		int num1 = Collections.min(num);
		int sum =0;
		int ssum=0;
		while(N>0) {

			sum+=pack1;
			if(N<6) {
				ssum+=num1*N;
			}
			else {
				ssum+=num1*6;
			}
			N-=6;
			min=Math.min(sum, ssum);
			
			sum=min;
			ssum=min;

		}
		System.out.println(min);
	}

}
