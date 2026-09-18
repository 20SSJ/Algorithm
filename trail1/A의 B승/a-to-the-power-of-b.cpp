#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int A, B, res = 1;
    cin >> A >> B;
    while(B--){
        res *= A;
    }
    cout << res;
    // Please write your code here.
    return 0;
}