using System;

public class Codetree
{  
    public static void Main()
    {
        int t = 0, N;
        bool bflg = true;
        for(int i = 0; i < 5; i++){
            N = int.Parse(Console.ReadLine());
            if(N % 3 != 0){
                Console.WriteLine(0);
                bflg = false;
                break;
            }
        }
        if(bflg) Console.WriteLine(1);
    }
}
