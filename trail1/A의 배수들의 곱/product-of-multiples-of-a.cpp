#include <iostream>
using namespace std;

int main() {
    int A, B, res, i;
    i = res = 1;
    cin >> A >> B;
    while(i <= B){
        if(i % A == 0){
            res *= i;
        }
        i++;
    }
    cout << res;
    return 0;
}