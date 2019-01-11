import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Number implements Comparable{
	int num;
	int sign;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}

	Number(int num, int sign){
		this.num=num;
		this.sign=sign;
	}
	public int compareTo(Number compareNumber) {
		int compareNum = ((Number)compareNumber).getNum();

		return this.num = compareNum;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
public class 백준2470 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);

		int N = sc.nextInt();
		Number[] arr = new Number[N];
		int[] sol = new int[N];
		for(int i=0;i<N;i++) {
			int n = sc.nextInt();
			if(n<0) {
				arr[i]= new Number(Math.abs(n),-1);
			}
			else {
				arr[i]= new Number(n,1);
			}
		}
		Arrays.sort(arr,new Comparator<Number>() {

			@Override
			public int compare(Number num1, Number num2) {
				if(num1.getNum() > num2.getNum())
					return 1;
				else if (num1.getNum() < num2.getNum())
					return -1;
				else return 0;
			}
		});
		
		int min = Integer.MAX_VALUE;
		int left =0;
		int right =0;

		for(int i=0;i<N;i++) {
			sol[i] = arr[i].num*arr[i].sign;
		}
		for(int i=0;i<N-1;i++) {
			if(min>Math.abs(sol[i]+sol[i+1])){
				min = Math.abs(sol[i]+sol[i+1]);
				left =i; right = i+1;
			}
		}
		int lo = sol[left]<sol[right]?sol[left]:sol[right];
		int hi = sol[left]>sol[right]?sol[left]:sol[right];
		System.out.println(lo+" "+hi);
	}
}
