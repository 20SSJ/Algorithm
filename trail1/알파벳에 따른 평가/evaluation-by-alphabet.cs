using System;

public class Codetree
{  
    public static void Main()
    {
        String score = Console.ReadLine();

        if (score == "S") Console.WriteLine("Superior");
        else if(score == "A") Console.WriteLine("Excellent");
        else if(score == "B") Console.WriteLine("Good");
        else if(score =="C") Console.WriteLine("Usually");
        else if(score == "D") Console.WriteLine("Effort");
        else Console.WriteLine("Failure");
    }
}
