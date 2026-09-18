#include <iostream>
using namespace std;

int main() {
    int A, B, res = 1;
    cin >> A >> B;
    while(A <= B){
        res *= A;
        A++;
    }
    cout << res;
    return 0;
}