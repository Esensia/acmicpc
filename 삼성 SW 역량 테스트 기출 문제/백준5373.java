import java.util.*;

public class Main {

	static int N;
	static String[][] dice = {{"0","0","0","o","o","o","0","0","0"},
			{"0","0","0","o","o","o","0","0","0"},
			{"0","0","0","o","o","o","0","0","0"},
			{"g","g","g","w","w","w","b","b","b"},
			{"g","g","g","w","w","w","b","b","b"},
			{"g","g","g","w","w","w","b","b","b"},
			{"0","0","0","r","r","r","0","0","0"},
			{"0","0","0","r","r","r","0","0","0"},
			{"0","0","0","r","r","r","0","0","0"},
			{"0","0","0","y","y","y","0","0","0"},
			{"0","0","0","y","y","y","0","0","0"},
			{"0","0","0","y","y","y","0","0","0"}};
	
	static String[][] init = {{"0","0","0","o","o","o","0","0","0"},
			{"0","0","0","o","o","o","0","0","0"},
			{"0","0","0","o","o","o","0","0","0"},
			{"g","g","g","w","w","w","b","b","b"},
			{"g","g","g","w","w","w","b","b","b"},
			{"g","g","g","w","w","w","b","b","b"},
			{"0","0","0","r","r","r","0","0","0"},
			{"0","0","0","r","r","r","0","0","0"},
			{"0","0","0","r","r","r","0","0","0"},
			{"0","0","0","y","y","y","0","0","0"},
			{"0","0","0","y","y","y","0","0","0"},
			{"0","0","0","y","y","y","0","0","0"}};

	static void lubix(String color, String dir) {
		String[][] backup = new String[12][9];
		for(int i=0;i<12;i++) {
			for(int j=0;j<9;j++) {
				backup[i][j]=dice[i][j];
			}
		}
		if(color.equals("U")) {
			if(dir.equals("+")) {
				dice[2][5] = backup[3][2];
				dice[2][4] = backup[4][2];
				dice[2][3] = backup[5][2];

				dice[3][2] = backup[6][3];
				dice[4][2] = backup[6][4];
				dice[5][2] = backup[6][5];

				dice[6][3] = backup[5][6];
				dice[6][4] = backup[4][6];
				dice[6][5] = backup[3][6];

				dice[5][6] = backup[2][5];
				dice[4][6] = backup[2][4];
				dice[3][6] = backup[2][3];
				
				dice[3][3] = backup[5][3];
				dice[3][4] = backup[4][3];
				dice[3][5] = backup[3][3];
				dice[4][3] = backup[5][4];
				dice[4][5] = backup[3][4];
				dice[5][3] = backup[5][5];
				dice[5][4] = backup[4][5];
				dice[5][5] = backup[3][5];
				
			}
			else {
				dice[2][5] = backup[5][6];
				dice[2][4] = backup[4][6];
				dice[2][3] = backup[3][6];

				dice[5][6] = backup[6][3];
				dice[4][6] = backup[6][4];
				dice[3][6] = backup[6][5];
				
				dice[6][3] = backup[3][2];
				dice[6][4] = backup[4][2];
				dice[6][5] = backup[5][2];
				
				dice[3][2] = backup[2][5];
				dice[4][2] = backup[2][4];
				dice[5][2] = backup[2][3];
				
				dice[3][3] = backup[3][5];
				dice[3][4] = backup[4][5];
				dice[3][5] = backup[5][5];
				dice[4][3] = backup[3][4];
				dice[4][5] = backup[5][4];
				dice[5][3] = backup[3][3];
				dice[5][4] = backup[4][3];
				dice[5][5] = backup[5][3];
			}
		}
		if(color.equals("D")) {
			if(dir.equals("+")) {
				dice[8][3] = backup[3][0];
				dice[8][4] = backup[4][0];
				dice[8][5] = backup[5][0];

				dice[3][0] = backup[0][5];
				dice[4][0] = backup[0][4];
				dice[5][0] = backup[0][3];

				dice[0][5] = backup[5][8];
				dice[0][4] = backup[4][8];
				dice[0][3] = backup[3][8];

				dice[5][8] = backup[8][3];
				dice[4][8] = backup[8][4];
				dice[3][8] = backup[8][5];
				
				dice[9][3] = backup[11][3];
				dice[9][4] = backup[10][3];
				dice[9][5] = backup[9][3];
				dice[10][3] = backup[11][4];
				dice[10][5] = backup[9][4];
				dice[11][3] = backup[11][5];
				dice[11][4] = backup[10][5];
				dice[11][5] = backup[9][5];
			}
			else {
				dice[8][3] = backup[5][8];
				dice[8][4] = backup[4][8];
				dice[8][5] = backup[3][8];

				dice[5][8] = backup[0][5];
				dice[4][8] = backup[0][4];
				dice[3][8] = backup[0][3];

				dice[0][5] = backup[3][0];
				dice[0][4] = backup[4][0];
				dice[0][3] = backup[5][0];

				dice[3][0] = backup[8][3];
				dice[4][0] = backup[8][4];
				dice[5][0] = backup[8][5];
				
				dice[9][3] = backup[9][5];
				dice[9][4] = backup[10][5];
				dice[9][5] = backup[11][5];
				dice[10][3] = backup[9][4];
				dice[10][5] = backup[11][4];
				dice[11][3] = backup[9][3];
				dice[11][4] = backup[10][3];
				dice[11][5] = backup[11][3];
			}
		}
		if(color.equals("F")) {
			if(dir.equals("+")) {
				dice[5][3] = backup[5][0];
				dice[5][4] = backup[5][1];
				dice[5][5] = backup[5][2];

				dice[5][0] = backup[9][5];
				dice[5][1] = backup[9][4];
				dice[5][2] = backup[9][3];

				dice[9][5] = backup[5][6];
				dice[9][4] = backup[5][7];
				dice[9][3] = backup[5][8];

				dice[5][6] = backup[5][3];
				dice[5][7] = backup[5][4];
				dice[5][8] = backup[5][5];
				
				dice[6][3] = backup[8][3];
				dice[6][4] = backup[7][3];
				dice[6][5] = backup[6][3];
				dice[7][3] = backup[8][4];
				dice[7][5] = backup[6][4];
				dice[8][3] = backup[8][5];
				dice[8][4] = backup[7][5];
				dice[8][5] = backup[6][5];
			}
			else {
				dice[5][3] = backup[5][6];
				dice[5][4] = backup[5][7];
				dice[5][5] = backup[5][8];

				dice[5][6] = backup[9][5];
				dice[5][7] = backup[9][4];
				dice[5][8] = backup[9][3];
				
				dice[9][5] = backup[5][0];
				dice[9][4] = backup[5][1];
				dice[9][3] = backup[5][2];
				
				dice[5][0] = backup[5][3];
				dice[5][1] = backup[5][4];
				dice[5][2] = backup[5][5];

				dice[6][3] = backup[6][5];
				dice[6][4] = backup[7][5];
				dice[6][5] = backup[8][5];
				dice[7][3] = backup[6][4];
				dice[7][5] = backup[8][4];
				dice[8][3] = backup[6][3];
				dice[8][4] = backup[7][3];
				dice[8][5] = backup[8][3];
			}
		}
		if(color.equals("B")) {
			if(dir.equals("+")) {
				dice[3][3] = backup[3][6];
				dice[3][4] = backup[3][7];
				dice[3][5] = backup[3][8];

				dice[3][6] = backup[11][5];
				dice[3][7] = backup[11][4];
				dice[3][8] = backup[11][3];

				dice[11][5] = backup[3][0];
				dice[11][4] = backup[3][1];
				dice[11][3] = backup[3][2];

				dice[3][0] = backup[3][3];
				dice[3][1] = backup[3][4];
				dice[3][2] = backup[3][5];
				
				dice[0][3] = backup[2][3];
				dice[0][4] = backup[1][3];
				dice[0][5] = backup[0][3];
				dice[1][3] = backup[2][4];
				dice[1][5] = backup[0][4];
				dice[2][3] = backup[2][5];
				dice[2][4] = backup[1][5];
				dice[2][5] = backup[0][5];
			}
			else {
				dice[3][3] = backup[3][0];
				dice[3][4] = backup[3][1];
				dice[3][5] = backup[3][2];

				dice[3][0] = backup[11][5];
				dice[3][1] = backup[11][4];
				dice[3][2] = backup[11][3];

				dice[11][5] = backup[3][6];
				dice[11][4] = backup[3][7];
				dice[11][3] = backup[3][8];

				dice[3][6] = backup[3][3];
				dice[3][7] = backup[3][4];
				dice[3][8] = backup[3][5];
				
				dice[0][3] = backup[0][5];
				dice[0][4] = backup[1][5];
				dice[0][5] = backup[2][5];
				dice[1][3] = backup[0][4];
				dice[1][5] = backup[2][4];
				dice[2][3] = backup[0][3];
				dice[2][4] = backup[1][3];
				dice[2][5] = backup[2][3];
			}
		}
		if(color.equals("L")) {
			if(dir.equals("+")) {
				dice[3][3] = backup[0][3];
				dice[4][3] = backup[1][3];
				dice[5][3] = backup[2][3];

				dice[0][3] = backup[9][3];
				dice[1][3] = backup[10][3];
				dice[2][3] = backup[11][3];

				dice[9][3] = backup[6][3];
				dice[10][3] = backup[7][3];
				dice[11][3] = backup[8][3];

				dice[6][3] = backup[3][3];
				dice[7][3] = backup[4][3];
				dice[8][3] = backup[5][3];
				
				dice[3][0] = backup[5][0];
				dice[3][1] = backup[4][0];
				dice[3][2] = backup[3][0];
				dice[4][0] = backup[5][1];
				dice[4][2] = backup[3][1];
				dice[5][0] = backup[5][2];
				dice[5][1] = backup[4][2];
				dice[5][2] = backup[3][2];
			}
			else {
				dice[3][3] = backup[6][3];
				dice[4][3] = backup[7][3];
				dice[5][3] = backup[8][3];

				dice[6][3] = backup[9][3];
				dice[7][3] = backup[10][3];
				dice[8][3] = backup[11][3];

				dice[9][3] = backup[0][3];
				dice[10][3] = backup[1][3];
				dice[11][3] = backup[2][3];

				dice[0][3] = backup[3][3];
				dice[1][3] = backup[4][3];
				dice[2][3] = backup[5][3];
				
				dice[3][0] = backup[3][2];
				dice[3][1] = backup[4][2];
				dice[3][2] = backup[5][2];
				dice[4][0] = backup[3][1];
				dice[4][2] = backup[5][1];
				dice[5][0] = backup[3][0];
				dice[5][1] = backup[4][0];
				dice[5][2] = backup[5][0];

			}
		}
		if(color.equals("R")) {
			if(dir.equals("+")) {
				dice[3][5] = backup[6][5];
				dice[4][5] = backup[7][5];
				dice[5][5] = backup[8][5];

				dice[6][5] = backup[9][5];
				dice[7][5] = backup[10][5];
				dice[8][5] = backup[11][5];

				dice[9][5] = backup[0][5];
				dice[10][5] = backup[1][5];
				dice[11][5] = backup[2][5];

				dice[0][5] = backup[3][5];
				dice[1][5] = backup[4][5];
				dice[2][5] = backup[5][5];
				
				dice[3][6] = backup[5][6];
				dice[3][7] = backup[4][6];
				dice[3][8] = backup[3][6];
				dice[4][6] = backup[5][7];
				dice[4][8] = backup[3][7];
				dice[5][6] = backup[5][8];
				dice[5][7] = backup[4][8];
				dice[5][8] = backup[3][8];
			}
			else {
				dice[3][5] = backup[0][5];
				dice[4][5] = backup[1][5];
				dice[5][5] = backup[2][5];

				dice[0][5] = backup[9][5];
				dice[1][5] = backup[10][5];
				dice[2][5] = backup[11][5];

				dice[9][5] = backup[6][5];
				dice[10][5] = backup[7][5];
				dice[11][5] = backup[8][5];

				dice[6][5] = backup[3][5];
				dice[7][5] = backup[4][5];
				dice[8][5] = backup[5][5];
				
				dice[3][6] = backup[3][8];
				dice[3][7] = backup[4][8];
				dice[3][8] = backup[5][8];
				dice[4][6] = backup[3][7];
				dice[4][8] = backup[5][7];
				dice[5][6] = backup[3][6];
				dice[5][7] = backup[4][6];
				dice[5][8] = backup[5][6];
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N=sc.nextInt();

		for(int i=0;i<N;i++) {
			int method = sc.nextInt();
			String tmp = sc.nextLine();
			String str = sc.nextLine();
			String[] string = str.split(" ");
			for(int j=0;j<string.length;j++) {
				String[] ord = string[j].split("");
				lubix(ord[0], ord[1]);
			}
			for(int r = 3; r<=5;r++) {
				for(int c = 3; c<=5;c++) {
					System.out.print(dice[r][c]);
				}
				System.out.println();
			}
			for(int r=0;r<12;r++) {
				for(int c=0;c<9;c++) {
					dice[r][c]=init[r][c];
				}
			}
		}
	}
}
