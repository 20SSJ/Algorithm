using System;

public class Codetree
{  
    public static void Main()
    {
        string[] input = Console.ReadLine().Split();
        int A = int.Parse(input[0]);
        int B = int.Parse(input[1]);
        if(A >= B) Console.WriteLine(1);
        else Console.WriteLine(0);
        if(A > B) Console.WriteLine(1);
        else Console.WriteLine(0);
        if(B >= A) Console.WriteLine(1);
        else Console.WriteLine(0);
        if(B > A) Console.WriteLine(1);
        else Console.WriteLine(0);
        if(A == B) Console.WriteLine(1);
        else Console.WriteLine(0);
        if(A != B) Console.WriteLine(1);
        else Console.WriteLine(0);
    }
}
