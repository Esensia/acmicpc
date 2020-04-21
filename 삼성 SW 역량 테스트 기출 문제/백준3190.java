import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

class Point{
	
	int x;
	int y;
}

public class Main {
	
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	static int N;
	static int K;
	static int L;
	
	static int[][] arr = new int[200][200];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int time =0;
		int[] X = new int[10101];
		String[] C = new String[10101];

		Point head = new Point();
		Point tail = new Point();
		Point[] pt = new Point[10101];
		int dir = 0;
		for(int i=0;i< 10101;i++) {
			pt[i] = new Point();
		}
		N = sc.nextInt();
		K = sc.nextInt();
		for(int i=0;i<K;i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			arr[r][c] = 2;
		}
		arr[1][1]=1;

		pt[1].x=1;
		pt[1].y=1;
		int headIndex =1;
		int tailIndex = 1;
		head.x = 1;
		head.y = 1;
		
		tail.x = 1;
		tail.y = 1;
		
		L = sc.nextInt();
		
		for(int i=0;i<L;i++) {
			int t = sc.nextInt();
			X[t] = 1;
			String c = sc.nextLine();
			for(int j=0;j<c.length();j++) {
				if(c.charAt(j)>64) {
					C[t] = String.valueOf(c.charAt(j));
				}
			}

		}
		while(true) {
			
			time++;
			head.y += dy[dir];
			head.x += dx[dir];
			
			if(arr[head.y][head.x]==1 || (head.y) > N || (head.y) < 1 ||
					(head.x) >N || (head.x) <1	){
				break;
			}
			if(arr[head.y][head.x]==2) {
				
				arr[head.y][head.x]=1;
				headIndex++;
				pt[headIndex].y = head.y;
				pt[headIndex].x = head.x;
				
			}
			if(arr[head.y][head.x]==0) {
				arr[head.y][head.x]=1;
				headIndex++;
				pt[headIndex].y = head.y;
				pt[headIndex].x = head.x;
				arr[pt[tailIndex].y][pt[tailIndex].x]=0;
				tailIndex++;
				
			}
			
			if(X[time]==1) {
				String c = C[time];
				if(c.equals("D")) {
					dir=(dir+1)%4;
				}
				else {
					dir=(dir+3)%4;
				}
			}
			
		}
		System.out.println(time);
	}
}