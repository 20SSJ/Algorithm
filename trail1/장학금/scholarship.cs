using System;

public class Codetree
{  
    public static void Main()
    {
        String[] inputs = Console.ReadLine().Split();
        int M = int.Parse(inputs[0]);
        int F = int.Parse(inputs[1]);
        if(M >= 90){
            if(F >= 95) Console.WriteLine(100000);
            else if(F >= 90) Console.WriteLine(50000);
            else Console.WriteLine(0);
        } else Console.WriteLine(0);
    }
}
