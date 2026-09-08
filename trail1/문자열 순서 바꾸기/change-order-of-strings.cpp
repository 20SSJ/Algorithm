#include <iostream>
using namespace std;

int main() {
    string S, T, tmp;
    cin >> S >> T;
    tmp = S;
    S = T;
    T = tmp;
    cout << S << "\n" << T;
    return 0;
}