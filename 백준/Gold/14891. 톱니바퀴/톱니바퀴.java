import java.io.*;
import java.util.*;

public class Main {

	static int[][] wheel;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		wheel = new int[5][8];
		
		for(int i = 1 ; i <= 4; i++) { // 1번부터 시작
			String str = br.readLine();
			for(int j = 0; j < 8; j++) {
				wheel[i][j] = str.charAt(j) - '0';
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		while(K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			int value = num;
			while(value > 1) { // 왼쪽 확인
				if(wheel[value][6] != wheel[value - 1][2]) {
					value--;
				}else break;
			}
			
			int Rvalue = num;
			while(Rvalue < 4) { // 오른쪽 확인
				if(wheel[Rvalue][2] != wheel[Rvalue + 1][6]) {
					Rvalue++;
				}else break;
			}
			
			if(dir == -1) {
				revClck(num);
					if(num - 1 >= value) Clck(num - 1);
					if(num + 1 <= Rvalue) Clck(num + 1);
					
					if(num - 2 >= value) revClck(num - 2);
					if(num + 2 <= Rvalue) revClck(num + 2);
					
					if(num - 3 >= value) Clck(num - 3);
					if(num + 3 <= Rvalue) Clck(num + 3);
			} else {
				Clck(num);
					if(num - 1 >= value) revClck(num - 1);
					if(num + 1 <= Rvalue) revClck(num + 1);
					if(num - 2 >= value) Clck(num - 2);
					if(num + 2 <= Rvalue) Clck(num + 2);
					if(num - 3 >= value) revClck(num - 3);
					if(num + 3 <= Rvalue) revClck(num + 3);
			}
		}
		
		int ans = 0;
		for(int i = 1; i <= 4; i++) {
			ans += wheel[i][0] * Math.pow(2, i - 1);
		}
		System.out.println(ans);
	}

	private static void revClck(int num) {
		int tmp = wheel[num][0];
		for(int a = 0; a < 7; a++) {
			wheel[num][a] = wheel[num][(a + 1)];
		}
		wheel[num][7] = tmp;
	}

	private static void Clck(int num) {
		int tmp = wheel[num][7];
		for(int a = 7; a > 0; a--) {
			wheel[num][a] = wheel[num][(a - 1)];
		}
		wheel[num][0] = tmp;
	}

}
