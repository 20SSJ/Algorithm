using System;

public class Codetree
{  
    public static void Main()
    {
        int A = int.Parse(Console.ReadLine());
        String[] inputs = Console.ReadLine().Split();
        int B = int.Parse(inputs[0]);
        int C = int.Parse(inputs[1]);
        int D = int.Parse(inputs[2]);
        int E = int.Parse(inputs[3]);

        Console.WriteLine(A > B ? 1 : 0);
        Console.WriteLine(A > C ? 1 : 0);
        Console.WriteLine(A > D ? 1 : 0);
        Console.WriteLine(A > E ? 1 : 0);
    }
}
