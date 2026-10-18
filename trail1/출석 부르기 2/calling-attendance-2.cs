using System;

public class Codetree
{  
    public static void Main()
    {
       int n;
       while(true){
        n = int.Parse(Console.ReadLine());
        if(n > 4){
            Console.WriteLine("Vacancy");
            break;
        }
        if(n == 1) Console.WriteLine("John");
        if(n == 2) Console.WriteLine("Tom");
        if(n == 3) Console.WriteLine("Paul");
        if(n == 4) Console.WriteLine("Sam");
       }
    }
}
