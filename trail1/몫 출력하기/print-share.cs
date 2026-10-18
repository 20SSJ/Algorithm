using System;

public class Codetree
{  
    public static void Main()
    {
        int n, cnt = 0;
        while(cnt != 3){
            n = int.Parse(Console.ReadLine());
            if(n % 2 == 0){
                cnt++;
                Console.WriteLine(n / 2);
            }
        }
    }
}
