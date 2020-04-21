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

	static int N;
	static int M;
	static int ans;
	static int[][] map = new int[501][501];
	static ArrayList<Integer> arr = new ArrayList();
	
	static void find(Point pt) {
		if(pt.x+3<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y][pt.x+1]+map[pt.y][pt.x+2]+map[pt.y][pt.x+3]);
		}
		if(pt.y+3<N) {
			arr.add(map[pt.y][pt.x]+map[pt.y+1][pt.x]+map[pt.y+2][pt.x]+map[pt.y+3][pt.x]);
		}
		if(pt.y+1<N && pt.x+1<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y][pt.x+1]+map[pt.y+1][pt.x]+map[pt.y+1][pt.x+1]);
		}
		if(pt.y+2<N && pt.x+1<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y+1][pt.x]+map[pt.y+2][pt.x]+map[pt.y+2][pt.x+1]);
		}
		if(pt.y+1<N && pt.x+2<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y+1][pt.x]+map[pt.y][pt.x+1]+map[pt.y][pt.x+2]);
		}
		if(pt.y+2<N && pt.x+1<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y][pt.x+1]+map[pt.y+1][pt.x+1]+map[pt.y+2][pt.x+1]);
		}
		if(pt.y-1>=0 && pt.x+2<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y][pt.x+1]+map[pt.y][pt.x+2]+map[pt.y-1][pt.x+2]);
		}
		if(pt.y+2<N && pt.x+1<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y][pt.x+1]+map[pt.y+1][pt.x]+map[pt.y+2][pt.x]);
		}
		if(pt.y+1<N && pt.x+2<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y][pt.x+1]+map[pt.y][pt.x+2]+map[pt.y+1][pt.x+2]);
		}
		if(pt.y+2<N && pt.x-1>=0) {
			arr.add(map[pt.y][pt.x]+map[pt.y+1][pt.x]+map[pt.y+2][pt.x]+map[pt.y+2][pt.x-1]);
		}
		if(pt.y+1<N && pt.x+2<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y+1][pt.x]+map[pt.y+1][pt.x+1]+map[pt.y+1][pt.x+2]);
		}
		if(pt.y+2<N && pt.x+1<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y+1][pt.x]+map[pt.y+1][pt.x+1]+map[pt.y+2][pt.x+1]);
		}
		if(pt.y-1>=0 && pt.x+2<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y][pt.x+1]+map[pt.y-1][pt.x+1]+map[pt.y-1][pt.x+2]);
		}
		if(pt.y-2>=0 && pt.x+1<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y-1][pt.x]+map[pt.y-1][pt.x+1]+map[pt.y-2][pt.x+1]);
		}
		if(pt.y+1<N && pt.x+2<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y][pt.x+1]+map[pt.y+1][pt.x+1]+map[pt.y+1][pt.x+2]);
		}
		if(pt.y+1<N && pt.x+2<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y][pt.x+1]+map[pt.y+1][pt.x+1]+map[pt.y][pt.x+2]);
		}
		if(pt.y-2>=0 && pt.x-1>=0) {
			arr.add(map[pt.y][pt.x]+map[pt.y-1][pt.x]+map[pt.y-2][pt.x]+map[pt.y-1][pt.x-1]);
		}
		if(pt.y-1>=0 && pt.x+2<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y][pt.x+1]+map[pt.y][pt.x+2]+map[pt.y-1][pt.x+1]);
		}
		if(pt.y+2<N && pt.x+1<M) {
			arr.add(map[pt.y][pt.x]+map[pt.y+1][pt.x]+map[pt.y+1][pt.x+1]+map[pt.y+2][pt.x]);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				Point pt = new Point();
				pt.x=j;
				pt.y=i;
				find(pt);
			}
		}
		System.out.println(Collections.max(arr));
	}
}