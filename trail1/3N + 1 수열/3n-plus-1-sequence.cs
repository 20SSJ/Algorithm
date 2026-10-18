using System;

public class Codetree
{  
    public static void Main()
    {
        int N = int.Parse(Console.ReadLine());
        int cnt = 0;
        while(true){
            if(N == 1) break;
            if(N % 2 == 0) N/=2;
            else N = N * 3 + 1;
            cnt++;
        }
        Console.WriteLine(cnt);
    }
}
