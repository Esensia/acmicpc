import java.util.*;

class Pair{
	int idx;
	int value;

	Pair(int idx, int value){
		this.idx=idx;
		this.value=value;
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);

		int N = sc.nextInt();
		LinkedList<Pair> list = new LinkedList();
		int[] p = new int[1001];

		for(int i=0;i<N;i++) {
			int v = sc.nextInt();
			list.add(new Pair(i,v));
		}

		Collections.sort(list, new Comparator<Pair>() { 
			@Override 
			public int compare(Pair o1, Pair o2) { 
				// TODO Auto-generated method stub 
				if (o1.value < o2.value) { 
					return -1; 
				} 
				else if (o1.value > o2.value) 
				{ 
					return 1; 
				} 
				else 
				{ 
					if (o1.idx < o2.idx) 
					{ 
						return -1; 
					} 
					else 
					{ 
						return 1; 
					} 
				} 
			} 
		});
		
		for(int i=0;i<N;i++) {
			p[list.get(i).idx]=i;
			
		}
		for(int i=0;i<N;i++) {
			System.out.print(p[i]+" ");
		}
	}

}


