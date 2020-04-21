import java.util.*;

class Shark{
	int r;
	int c;
	int s;
	int d;
	int z;
}
public class Main {

	static int R;
	static int C;
	static int M;

	static Shark[][] map = new Shark[101][101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		M = sc.nextInt();

		int hap=0;

		int humanPos = 0;

		for(int i=0;i<M;i++) {
			Shark shark = new Shark();

			shark.r = sc.nextInt();
			shark.c = sc.nextInt();
			shark.s = sc.nextInt();
			shark.d = sc.nextInt();
			shark.z = sc.nextInt();

			map[shark.r][shark.c] = shark;
		}
		while(true) {

			humanPos++;
			for(int i=1;i<=R;i++) {
				if(map[i][humanPos]!=null) {
					hap+=map[i][humanPos].z;
					map[i][humanPos]=null;
					break;
				}
			}

			Shark[][] backup = new Shark[101][101];
			for(int i=1;i<=R;i++) {
				for(int j=1;j<=C;j++) {
					if(map[i][j]!=null) {
						int s = map[i][j].s;
						while(map[i][j].s>0) {
							if(map[i][j].d ==1) {
								if(map[i][j].r - map[i][j].s>=1) {
									map[i][j].r = (map[i][j].r-map[i][j].s);
									map[i][j].s =0;
								}
								else {
									int dis = map[i][j].r - 1;
									map[i][j].r = (map[i][j].r-dis);
									map[i][j].s -= dis;
									map[i][j].d = 2;
								}
							}
							if(map[i][j].d ==2) {
								if(map[i][j].r + map[i][j].s<=R) {
									map[i][j].r = (map[i][j].r+map[i][j].s);
									map[i][j].s =0;
								}
								else {
									int dis = R - map[i][j].r;
									map[i][j].r = (map[i][j].r+dis);
									map[i][j].s -= dis;
									map[i][j].d = 1;
								}
							}
							if(map[i][j].d ==3) {
								if(map[i][j].c + map[i][j].s<=C) {
									map[i][j].c = (map[i][j].c+map[i][j].s);
									map[i][j].s =0;
								}
								else {
									int dis = C - map[i][j].c;
									map[i][j].c = (map[i][j].c+dis);
									map[i][j].s -= dis;
									map[i][j].d = 4;
								}
							}
							if(map[i][j].d ==4) {
								if(map[i][j].c - map[i][j].s>=1) {
									map[i][j].c = (map[i][j].c-map[i][j].s);
									map[i][j].s =0;
								}
								else {
									int dis = map[i][j].c -1 ;
									map[i][j].c = (map[i][j].c-dis);
									map[i][j].s -= dis;
									map[i][j].d = 3;
								}
							}
						}
						if(backup[map[i][j].r][map[i][j].c]==null) {
							backup[map[i][j].r][map[i][j].c]=map[i][j];
							backup[map[i][j].r][map[i][j].c].s = s;
						}
						else {
							if(backup[map[i][j].r][map[i][j].c].z<map[i][j].z) {
								backup[map[i][j].r][map[i][j].c]=map[i][j];
								backup[map[i][j].r][map[i][j].c].s = s;
							}
						}
					}
				}
			}

			for(int i=1;i<=R;i++) {
				for(int j=1;j<=C;j++) {
					map[i][j]=backup[i][j];
				}
			}
			if(humanPos == C) {
				break;
			}
		}
		System.out.println(hap);

	}
}
