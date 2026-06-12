import java.util.Scanner;

public class Solution {
	
	private static int calc(int N, int M) {
		if(M == 0) return 1;
		if(M == 1) return N;
		
		int half = calc(N, M / 2);
		
		if(M % 2 == 0) {
			return half * half;
		}
		
		else return half * half * N;
		
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tc = 0;
		while(tc != 10) {
			tc = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.print("#" + tc + " ");
			System.out.println(calc(N, M));
		}
	}
}
