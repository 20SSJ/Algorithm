using System;

public class Codetree
{  
    public static void Main()
    {
        float a = float.Parse(Console.ReadLine());
        float b = float.Parse(Console.ReadLine());

        if (a >= 1.0f && b >= 1.0f) Console.WriteLine("High");
        else if (a >= 0.5f && b >= 0.5f) Console.WriteLine("Middle");
        else Console.WriteLine("Low");
    }
}