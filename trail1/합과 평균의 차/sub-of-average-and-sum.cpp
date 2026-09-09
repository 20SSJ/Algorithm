#include <iostream>
using namespace std;

int main() {
    int a, b, c;
    cin >> a >> b >> c;
    int sm = a + b + c;
    int mean = sm / 3;
    cout << sm << "\n" << mean << "\n" << sm - mean; 
    return 0;
}