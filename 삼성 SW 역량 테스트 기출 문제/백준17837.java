import java.util.*;

class Horse{
	int y;
	int x;
	int dir;

	public Horse() {

	}

	public Horse(int y, int x, int dir) {
		this.y = y;
		this.x = x;
		this.dir = dir;
	}
}

class Map{
	int num;
	LinkedList<Horse> arr;
}

public class Main {

	static int N;
	static int K;
	static Map[][] map = new Map[13][13];
	static Horse[] horse = new Horse[11];
	static int[] dx = {0,1,-1,0,0};
	static int[] dy = {0,0,0,-1,1};

	static int ans;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		int turn = 0;

		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				map[i][j] = new Map();
				map[i][j].num = sc.nextInt();
				map[i][j].arr = new LinkedList();
			}
		}
		for(int i=0;i<K;i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int dir = sc.nextInt();
			horse[i]= new Horse(y,x,dir);
			map[y][x].arr.add(horse[i]);
		}


		while(true) {
			turn++;
			if(turn>1000) {
				ans = -1;
				break;
			}
			int flag = 0;
			for(int i=0;i<K;i++) {

				Horse cur = new Horse();
				cur.y = horse[i].y;
				cur.x = horse[i].x;
				cur.dir = horse[i].dir;

				int sy = cur.y + dy[cur.dir];
				int sx = cur.x + dx[cur.dir];

				if(sy>=1 && sx>=1 && sy<=N && sx<=N && map[sy][sx].num==0 ) {
					int size = map[cur.y][cur.x].arr.size();
					int index = map[cur.y][cur.x].arr.indexOf(horse[i]);
					LinkedList<Horse> ll = new LinkedList();
					for(int j=size-1;j>=index;j--) {
						map[cur.y][cur.x].arr.get(j).y = sy;
						map[cur.y][cur.x].arr.get(j).x = sx;
						ll.add(map[cur.y][cur.x].arr.pollLast());
					}
					for(int j=index;j<size;j++) {
						map[sy][sx].arr.add(ll.pollLast());
						if(map[sy][sx].arr.size()>=4) {
							flag =1;
							break;
						}
					}
				}
				if(flag==1) {
					break;
				}
				if(sy>=1 && sx>=1 && sy<=N && sx<=N && map[sy][sx].num==1) {
					int size = map[cur.y][cur.x].arr.size();
					int index = map[cur.y][cur.x].arr.indexOf(horse[i]);
					for(int j=size-1;j>=index;j--) {
						map[cur.y][cur.x].arr.get(j).y = sy;
						map[cur.y][cur.x].arr.get(j).x = sx;
						map[sy][sx].arr.add(map[cur.y][cur.x].arr.pollLast());
						if(map[sy][sx].arr.size()>=4) {
							flag =1;
							break;
						}
					}
				}
				if(flag==1) {
					break;
				}
				if(sy>N || sx>N || sy<1 || sx<1 || map[sy][sx].num==2) {
					int size = map[cur.y][cur.x].arr.size();
					int index = map[cur.y][cur.x].arr.indexOf(horse[i]);
					if(map[cur.y][cur.x].arr.get(index).dir==1) {
						map[cur.y][cur.x].arr.get(index).dir =2;
					}
					else if(map[cur.y][cur.x].arr.get(index).dir==2) {
						map[cur.y][cur.x].arr.get(index).dir =1;
					}
					else if(map[cur.y][cur.x].arr.get(index).dir==3) {
						map[cur.y][cur.x].arr.get(index).dir =4;
					}
					else if(map[cur.y][cur.x].arr.get(index).dir==4) {
						map[cur.y][cur.x].arr.get(index).dir =3;
					}

					cur.dir = horse[i].dir;
					sy = cur.y + dy[cur.dir];
					sx = cur.x + dx[cur.dir];

					if(sy>N || sx>N || sy<1 || sx<1 || map[sy][sx].num==2) {

					}
					if(sy>=1 && sx>=1 && sy<=N && sx<=N && map[sy][sx].num==0 ) {
						LinkedList<Horse> ll = new LinkedList();
						for(int j=size-1;j>=index;j--) {
							map[cur.y][cur.x].arr.get(j).y = sy;
							map[cur.y][cur.x].arr.get(j).x = sx;
							ll.add(map[cur.y][cur.x].arr.pollLast());
						}
						for(int j=index;j<size;j++) {
							map[sy][sx].arr.add(ll.pollLast());
							if(map[sy][sx].arr.size()>=4) {
								flag =1;
								break;
							}
						}
					}
					if(flag==1) {
						break;
					}
					if(sy>=1 && sx>=1 && sy<=N && sx<=N && map[sy][sx].num==1) {
						for(int j=size-1;j>=index;j--) {
							map[cur.y][cur.x].arr.get(j).y = sy;
							map[cur.y][cur.x].arr.get(j).x = sx;
							map[sy][sx].arr.add(map[cur.y][cur.x].arr.pollLast());
							if(map[sy][sx].arr.size()>=4) {
								flag =1;
								break;
							}
						}
					}
					if(flag==1) {
						break;
					}
				}
				
			}
			if(flag==1) {
				break;
			}
		}
		if(ans!=-1) {
			ans = turn;
		}
		System.out.println(ans);
	}
}