
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		String[] ant = new String[T];
		
		ant[0]="1";
		
		for(int i=1;i<T;i++) {
			
			ant[i]="1";
			int count=1;
			
			for(int j=1;j<ant[i-1].length();j++) {
				
				if(ant[i-1].charAt(j)==ant[i-1].charAt(j-1)) {
					count++;
				}
				else {
					ant[i]+=(String.valueOf(count)+ant[i-1].charAt(j)); //이전 수의 개수와 지금의 숫자입력
					count=1; 
				}
				
			}
			ant[i]+=count; // 마지막 숫자의 개수 입력			
		}
		
		//출력확인
		for(int i=0;i<T;i++) {
			System.out.println(ant[i]);
		}
	}
}

