using System;

public class Codetree
{  
    public static void Main()
    {
        string[] inputs = Console.ReadLine().Split();
        int A_Math = int.Parse(inputs[0]);
        int A_En = int.Parse(inputs[1]);

        string[] inputs2 = Console.ReadLine().Split();
        int B_Math = int.Parse(inputs2[0]);
        int B_En = int.Parse(inputs2[1]);

        if(A_Math > B_Math && A_En > B_En) Console.WriteLine(1);
        else Console.WriteLine(0);
    }
}
