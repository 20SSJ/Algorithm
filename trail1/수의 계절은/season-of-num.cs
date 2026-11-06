using System;

public class Codetree
{  
    public static void Main()
    {
        int M = int.Parse(Console.ReadLine());
        if(M == 3 || M == 4 || M == 5) Console.WriteLine("Spring");
        else if(M == 6 || M == 6 || M == 7 || M == 8) Console.WriteLine("Summer");
        else if(M == 9 || M == 10 || M == 11) Console.WriteLine("Fall");
        else Console.WriteLine("Winter");
    }
}
