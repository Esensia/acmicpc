import java.util.*;

public class Main {

	static int[][] map = new int[101][101];

	static int R;
	static int C;
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();
		int time =0;

		for(int i=1;i<=3;i++) {
			for(int j=1;j<=3;j++) {
				map[i][j]=sc.nextInt();
			}
		}

		int r=3;
		int c=3;
		while(true) {
			if(map[R][C]==K) {
				break;
			}
			if(time>100) {
				time=-1;
				break;
			}
			int[][] backup = new int[101][101];
			if(r>=c) {
				for(int i=1;i<=r;i++) {
					int flag=0;
					int[] num = new int[101];
					for(int j=1; j<=c;j++) {
						num[map[i][j]]++;
				
					}
					ArrayList<Integer> arr = new ArrayList();
					for(int j=1;j<=100;j++) {
						if(flag==1) {
							break;
						}
						for(int k=1;k<=100;k++) {
							if(arr.size()>=100) {
								flag=1;
								break;
							}
							if(num[k]==j) {
								arr.add(k);
								if(arr.size()<100) {
									arr.add(j);
								}

							}
						}
					}
					for(int j=0;j<arr.size();j++) {
						backup[i][j+1]=arr.get(j);
					}
				}
				int max =0;
				for(int i=1;i<=100;i++) {
					for(int j=1;j<=100;j++) {
						if(backup[i][j]==0) {
							if(max<j) {
								max=j;
							}
							break;
						}
					}
				}
				for(int i=1;i<=100;i++) {
					for(int j=1;j<=100;j++) {
						map[i][j]=backup[i][j];
					}
				}
				c = max;
			}
			else {
				for(int i=1;i<=c;i++) {
					int flag=0;
					int[] num = new int[101];
					for(int j=1; j<=r;j++) {
						num[map[j][i]]++;
					}
					ArrayList<Integer> arr = new ArrayList();
					for(int j=1;j<=100;j++) {
						if(flag==1) {
							break;
						}
						for(int k=1;k<=100;k++) {
							if(arr.size()>=100) {
								flag=1;
								break;
							}
							if(num[k]==j) {
								arr.add(k);
								if(arr.size()<100) {
									arr.add(j);
								}

							}
						}
					}
					for(int j=0;j<arr.size();j++) {
						backup[j+1][i]=arr.get(j);
					}
				}
				int max =0;
				for(int i=1;i<=100;i++) {
					for(int j=1;j<=100;j++) {
						if(backup[j][i]==0) {
							if(max<j) {
								max=j;
							}
							break;
						}
					}
				}
				for(int i=1;i<=100;i++) {
					for(int j=1;j<=100;j++) {
						map[i][j]=backup[i][j];
					}
				}
				r = max;
			}
			time++;

		}
		System.out.println(time);
	}
}
