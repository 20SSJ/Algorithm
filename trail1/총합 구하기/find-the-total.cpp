#include <iostream>
using namespace std;

int main() {
    int A, B, res = 0;
    cin >> A >> B;
    while(A <= B){
        if(A % 6 == 0 && A % 8 != 0){
            res += A;
        }
        A++;
    }
    cout << res;
    return 0;
}