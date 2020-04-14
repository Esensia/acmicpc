import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static int N;
	static int[] nums;
	static int[] prefix;
	static int max;
	static boolean[] visited;

	private static void dfs(int count, int dx) {
		// TODO Auto-generated method stub

		operation();

		for(int i=dx;i<nums.length;i++) {
			if(!visited[i]) {
				if(i==0) {
					visited[i]=true;
					dx++;
					dfs(count+1,dx);
					visited[i]=false;

				}
				else {
					if(visited[i-1]==false) {
						if(i+1<visited.length && !visited[i+1]) {
							visited[i]=true;
							dx++;
							dfs(count+1,dx);
							visited[i]=false;
						}


					}
				}
			}
		}
	}

	private static void operation() {
		// TODO Auto-generated method stub

		LinkedList<Integer> arr = new LinkedList();
		LinkedList<Integer> brr = new LinkedList();

		for(int i=0;i<visited.length;i++) {
			if(visited[i] && i <visited.length-1) {
				if(prefix[i]==1) {
					arr.add(nums[i]+nums[i+1]);
					if(i+1<prefix.length)
						brr.add(prefix[i+1]);
				}
				if(prefix[i]==2) {
					arr.add(nums[i]-nums[i+1]);
					if(i+1<prefix.length)
						brr.add(prefix[i+1]);
				}
				if(prefix[i]==3) {
					arr.add(nums[i]*nums[i+1]);
					if(i+1<prefix.length)
						brr.add(prefix[i+1]);
				}
			}
			else if(visited[i] && i == visited.length-1) {
				arr.add(nums[i]);
			}
			else {
				if(i==0) {
					arr.add(nums[i]);
					brr.add(prefix[i]);
				}
				if(i>0 && !visited[i-1]) {
					arr.add(nums[i]);
					if(i<prefix.length) {
						brr.add(prefix[i]);
					}
				}

			}
		}

		int ans = 0;
		ans += arr.get(0);
		for(int i=0;i<brr.size();i++) {
			if(brr.get(i)==1) {
				ans+=arr.get(i+1);
			}
			if(brr.get(i)==2) {
				ans-=arr.get(i+1);
			}
			if(brr.get(i)==3) {
				ans*=arr.get(i+1);
			}
		}
		if(ans>max) {
			max = ans;

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		String tmp = sc.nextLine();

		String str = sc.nextLine();
		if(N==1) {
			System.out.println(str);
		}
		else {
			String[] string = str.split("");

			nums = new int[N/2+1];
			prefix = new int[N/2];
			visited = new boolean[N/2+1];
			max = Integer.MIN_VALUE;

			int j=0;
			int k=0;

			for(int i=0;i<str.length();i++) {
				if(i%2==0) {
					nums[j]=Integer.parseInt(string[i]);
					j++;
				}
				else {
					if(string[i].equals("+")) {
						prefix[k]=1;
						k++;
					}
					if(string[i].equals("-")) {
						prefix[k]=2;
						k++;
					}
					if(string[i].equals("*")) {
						prefix[k]=3;
						k++;
					}
				}
			}

			dfs(0,0);
			System.out.println(max);
		}
	}
}