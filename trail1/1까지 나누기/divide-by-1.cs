using System;

public class Codetree
{  
    public static void Main()
    {
        int N = int.Parse(Console.ReadLine());
        int size = N;
        for(int i = 1; i <= size; i++){
            if(N / i <= 1){
                Console.Write(i);
                break;
            }
            N /= i;
        }
    }
}
