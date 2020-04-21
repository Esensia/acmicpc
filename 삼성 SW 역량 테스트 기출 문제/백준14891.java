import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static int[][][] map = new int[5][3][3];
	static int[] rot = new int[5];
	static int K;

	static void rotation(int tire, int dir) {
		int left = tire;
		int right = tire;

		int[][][] tmp = new int[5][3][3];
		for(int k=1;k<=4;k++) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					tmp[k][i][j]=map[k][i][j];
				}
			}
		} 
		while(true) {
			if(left>1) {
				if(map[left][1][0]!=map[left-1][1][2]) {
					rot[left-1]=rot[left]*(-1);
					left--;
				}
				else {
					left=1;
				}
			}
			if(right<4) {
				if(map[right][1][2]!=map[right+1][1][0]) {
					rot[right+1]=rot[right]*(-1);
					right++;
				}
				else {
					right=4;
				}
			}
			if(left==1 && right==4) {
				break;
			}
		}
		for(int k=1;k<=4;k++) {
			if(rot[k]==1) {
				map[k][0][0]=tmp[k][1][0];
				map[k][0][1]=tmp[k][0][0];
				map[k][0][2]=tmp[k][0][1];
				map[k][1][0]=tmp[k][2][0];
				map[k][1][2]=tmp[k][0][2];
				map[k][2][0]=tmp[k][2][1];
				map[k][2][1]=tmp[k][2][2];
				map[k][2][2]=tmp[k][1][2];
			}
			else if(rot[k]==-1) {
				map[k][0][0]=tmp[k][0][1];
				map[k][0][1]=tmp[k][0][2];
				map[k][0][2]=tmp[k][1][2];
				map[k][1][0]=tmp[k][0][0];
				map[k][1][2]=tmp[k][2][2];
				map[k][2][0]=tmp[k][1][0];
				map[k][2][1]=tmp[k][2][0];
				map[k][2][2]=tmp[k][2][1];
			}
		}

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		for(int i=1;i<=4;i++) {
			String str = sc.nextLine();
			String[] string = str.split("");
			map[i][0][1]=Integer.parseInt(string[0]);
			map[i][0][2]=Integer.parseInt(string[1]);
			map[i][1][2]=Integer.parseInt(string[2]);
			map[i][2][2]=Integer.parseInt(string[3]);
			map[i][2][1]=Integer.parseInt(string[4]);
			map[i][2][0]=Integer.parseInt(string[5]);
			map[i][1][0]=Integer.parseInt(string[6]);
			map[i][0][0]=Integer.parseInt(string[7]);
		}
		K = sc.nextInt();
		for(int i=0;i<K;i++) {
			int tire = sc.nextInt();
			int dir = sc.nextInt();
			rot[tire]=dir;
			rotation(tire,dir);
			for(int j=1;j<=4;j++) {
				rot[j]=0;
			}
		}
		int sum =0;
		
		
		for(int i=1;i<=4;i++) {
			if(map[i][0][1]==1) {
				sum+=Math.pow(2, i-1);
			}
		}
		System.out.println(sum);
	}
}