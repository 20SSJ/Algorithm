using System;

public class Codetree
{  
    public static void Main()
    {
        string[] input = Console.ReadLine().Split();
        int A = int.Parse(input[0]);
        int B = int.Parse(input[1]);

        Console.WriteLine(A >= B ? 1 : 0);
        Console.WriteLine(A > B ? 1 : 0);
        Console.WriteLine(B >= A ? 1 : 0);
        Console.WriteLine(B > A ? 1 : 0);
    }
}
