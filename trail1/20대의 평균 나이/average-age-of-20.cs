using System;

public class Codetree
{  
    public static void Main()
    {
        int n, cnt, sm;
        cnt = sm = 0;
        while(true){
            n = int.Parse(Console.ReadLine());
            if(n < 20 || n >= 30) break;
            sm += n;
            cnt++;
        }
        double avg = (double)sm / cnt;
        Console.WriteLine(avg.ToString("F2"));
    }
}
