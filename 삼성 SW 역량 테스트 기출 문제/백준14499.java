import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

class Dice{
	int d1;
	int d2;
	int d3;
	int d4;
	int d5;
	int d6;
	int posX;
	int posY;
}

public class Main {

	static int N;
	static int M;
	static int x;
	static int y;
	static int K;

	static int[][] map = new int[21][21];
	static Dice dice = new Dice(); 
	static int ans;

	static void game(int comm) {
		int dir=0;
		Dice tmp = new Dice();
		tmp.d1=dice.d1;
		tmp.d2=dice.d2;
		tmp.d3=dice.d3;
		tmp.d4=dice.d4;
		tmp.d5=dice.d5;
		tmp.d6=dice.d6;
		tmp.posX = dice.posX;
		tmp.posY = dice.posY;
		
		dice.d1 = 0;
		dice.d2 = 0;
		dice.d3 = 0;
		dice.d4 = 0;
		dice.d5 = 0;
		dice.d6 = 0;

		if(comm==1 && dice.posX+1<M) {
			dice.d1 = tmp.d1;
			dice.d2 = tmp.d6;
			dice.d3 = tmp.d2;
			dice.d4 = tmp.d3;
			dice.d5 = tmp.d5;
			dice.d6 = tmp.d4;
			dice.posX++;
		}
		if(comm==2 && dice.posX-1>=0) {
			dice.d1 = tmp.d1;
			dice.d2 = tmp.d3;
			dice.d3 = tmp.d4;
			dice.d4 = tmp.d6;
			dice.d5 = tmp.d5;
			dice.d6 = tmp.d2;
			dice.posX--;
		}
		if(comm==3 && dice.posY-1>=0) {
			dice.d1 = tmp.d3;
			dice.d2 = tmp.d2;
			dice.d3 = tmp.d5;
			dice.d4 = tmp.d4;
			dice.d5 = tmp.d6;
			dice.d6 = tmp.d1;
			dice.posY--;
		}
		if(comm==4 && dice.posY+1<N){
			dice.d1 = tmp.d6;
			dice.d2 = tmp.d2;
			dice.d3 = tmp.d1;
			dice.d4 = tmp.d4;
			dice.d5 = tmp.d3;
			dice.d6 = tmp.d5;
			dice.posY++;

		}

		if(dice.posX == tmp.posX && dice.posY == tmp.posY) {
			dir =1;
			dice.d1=tmp.d1;
			dice.d2=tmp.d2;
			dice.d3=tmp.d3;
			dice.d4=tmp.d4;
			dice.d5=tmp.d5;
			dice.d6=tmp.d6;
		
		}
		if(dir ==0) {
			if(map[dice.posY][dice.posX]==0) {
				map[dice.posY][dice.posX] = dice.d6;

			}
			else
			{
				dice.d6 = map[dice.posY][dice.posX];
				map[dice.posY][dice.posX] = 0;

			}
			System.out.println(dice.d3);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		K = sc.nextInt();

		dice.posX = y;
		dice.posY = x;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<K;i++) {
			int comm = sc.nextInt();
			game(comm);
		}
	}
}