using System;

public class Codetree
{  
    public static void Main()
    {
        int N, cnt = 0;
        N = int.Parse(Console.ReadLine());
        while(N < 1000){
            if(N % 2 == 0){
                N = N * 3 + 1;
            } else{
                N = N * 2 + 2;
            }
            cnt++;
        }
        Console.WriteLine(cnt);
    }
}
