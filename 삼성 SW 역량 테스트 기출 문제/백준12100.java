import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static int N;

	static int[][][] arr = new int[5461][25][25];
	static Queue<Integer> que = new LinkedList();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int count = 0;
		N = sc.nextInt();
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[0][i][j] = sc.nextInt();
				if (max < arr[0][i][j]) {
					max = arr[0][i][j];
				}
			}
		}
		que.add(0);
		int new_index = 0;
		int start_index = 0;
		while (true) {
			if(que.isEmpty()) {
				break;
			}
			int index = que.poll();

			if(index == start_index*4 +1) {
				count++;
				start_index = start_index * 4 + 1;
			}

			if(count>5) {
				break;
			}
			int[][] tmp = new int[25][25];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					tmp[i][j] = arr[index][i][j];
				}
			}

			new_index = index * 4;

			for (int i = 0; i < 4; i++) {

				new_index++;
				
				for (int j = 0; j < N; j++) {
					 
					for (int k = 0; k < N; k++) {
						arr[new_index][j][k] = tmp[j][k];
						//System.out.println(new_index +" "+ j +" "+k);
					}

				}

				for(int j=0; j < N; j++) {
					for(int k=0;k<N;k++) {
						if(arr[new_index][k][j]==0) {
							int kk=k;
							while(true) {
								k++;
								if(k==N) {
									k=kk;
									break;
								}
								if(arr[new_index][k][j]!=0) {
									arr[new_index][kk][j]=arr[new_index][k][j];
									arr[new_index][k][j]=0;
									k=kk;
									break;
								}
							}
						}
					}
				}
				
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {

						if(k<N-1) {
							if(arr[new_index][k][j]==arr[new_index][k+1][j] && arr[new_index][k][j]!=0) {
								arr[new_index][k][j] *= 2;
								arr[new_index][k+1][j] =0;

							}
						}

					}
				}
			
				for(int j=0; j < N; j++) {
					for(int k=0;k<N;k++) {
						if(arr[new_index][k][j]==0) {
							int kk=k;
							while(true) {
								k++;
								if(k==N) {
									k=kk;
									break;
								}
								if(arr[new_index][k][j]!=0) {
									arr[new_index][kk][j]=arr[new_index][k][j];
									arr[new_index][k][j]=0;
									k=kk;
									break;
								}
							}
						}
					}
				}
				
				if(new_index<=340) {
					que.add(new_index);
				}

				int[][] tmp1 = new int[25][25];
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						tmp1[j][k] = tmp[j][k];
					}
				}

				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						tmp[k][N-1-j] = tmp1[j][k];
					}
				}

				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if(max<arr[new_index][j][k]) {
							max=arr[new_index][j][k];
							
						}
					}
				}


			}
		}
		System.out.println(max);
	}
}