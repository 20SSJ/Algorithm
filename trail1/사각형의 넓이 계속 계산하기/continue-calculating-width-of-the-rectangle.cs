using System;

public class Codetree
{  
    public static void Main()
    {
        string[] inputs;
        while(true){
            inputs = Console.ReadLine().Split();
            int r = int.Parse(inputs[0]);
            int c = int.Parse(inputs[1]);
            Console.WriteLine(r * c);
            if(inputs[2] == "C") break;
        }
    }
}
