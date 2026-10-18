using System;

public class Codetree
{  
    public static void Main()
    {
        int answer = 25;
        int n;
        while(true){
            n = int.Parse(Console.ReadLine());
            if(n == answer){
                Console.WriteLine("Good");
                break;
            }
            if(n > answer) Console.WriteLine("Lower");
            if(n < answer) Console.WriteLine("Higher");
        }
    }
}
