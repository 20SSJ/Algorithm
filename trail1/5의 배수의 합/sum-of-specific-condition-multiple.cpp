#include <iostream>
using namespace std;

int main() {
    int big, small, A, B, res = 0;
    cin >> A >> B;
    if(A > B){
        big = A;
        small = B;
    } else{
        big = B;
        small = A;
    }
        
    while(small <= big){
        if(small % 5 == 0) res += small;
        small++;
    }
    cout << res;
    return 0;
}