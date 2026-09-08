#include <iostream>
using namespace std;

int main() {
    double ft = 30.48, N;
    cin >> N;
    cout << fixed;
    cout.precision(1);
    cout << N * ft;
    return 0;
}